import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
/*
Question:
LRU (Least Recently used) cache를 구현한다.
입력명령어 종류
exit = 종료
evict = 가장 이전에 access된 멤버를 삭제한다.
add = 캐시에 키/값 추가
get = key를 입력 받아 값을 출력
remove = 입력된 값을 삭제한다.

예)
add 1 100
add 2 200
add 3 300
add 4 400
get 1
evict
remove 1
*/
public class 캐시구현_LRU {


    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";

        while(true){

            input = br.readLine();
            if(input.equals("exit")) return;
            else if(input.equals("evict")){
                evict();
            }
            else{
                String[] inputArr = input.split(" ");
                String oper = inputArr[0];
                if(oper.equals("add")){
                    long key =  Long.parseLong(inputArr[1]);
                    long val =  Long.parseLong(inputArr[2]);

                    add(key, val);
                }
                else if(oper.equals("get")){
                    long key =  Long.parseLong(inputArr[1]);
                    System.out.println(get(key) );
                }
                else if(oper.equals("remove")){
                    long key =  Long.parseLong(inputArr[1]);
                    System.out.println(remove(key));
                }
                else if(oper.equals("all")){
                    System.out.println(lookUp );
                    System.out.println(nodes );
                }
                else{
                    continue;
                }


            }


        }
    }

    private static HashMap<Long, Long> lookUp = new HashMap<Long, Long>();;
    private static LinkedList<Object> nodes =  new LinkedList<Object>();;


    public static long get(long key) {
        if (lookUp.get(key) == null) {
            return -1;
        } else {
            moveToFirst(key);
            return lookUp.get(key);
        }
    }


    private static void moveToFirst(Object key){
        nodes.removeFirstOccurrence(key);
        nodes.addFirst(key);
    }


    public static void add(long key, long value) {

        if (lookUp.get(key) == null) {
            nodes.addFirst(key);
        } else {
            moveToFirst(key);
        }

        lookUp.put(key, value);

    }

    private static void evict(){
        long last = (long) nodes.removeLast();
        lookUp.remove(last);
    }

    private static long remove(long key){
        if(lookUp.get(key) == null){
            return -1;
        }
        else {
            long rmVal = lookUp.get(key);
            nodes.remove(key);
            lookUp.remove(key);
            return rmVal;
        }
    }

}
