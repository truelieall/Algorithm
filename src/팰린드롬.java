
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Question:백준알고리즘
입력된 문자열 안의 팰린드롬을 구한 후 해당 문자열을
구성할 수 있는 최소 팰린드롬 갯수를 구한다.
 */


public class 팰린드롬 {
    public static void main(String arg[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println("처리전 Free Memory " + Runtime.getRuntime().freeMemory()/1024/1024 + "MB");

        System.out.println(minPalindrome(str));

        System.out.println("처리후 Free Memory " + Runtime.getRuntime().freeMemory()/1024/1024 + "MB");

    }

    public static int minPalindrome(String str) {

        Boolean[][] cache = new Boolean[str.length()][];

        for(int i=0; i<cache.length; i++){
            cache[i] = new Boolean[cache.length - i];
        }

        System.out.println("처리전-1 Free Memory " + Runtime.getRuntime().freeMemory()/1024/1024 + "MB");

        for(int i=0; i<cache.length; i++) {
            for(int j=i; j< i + cache[i].length; j++)
                isPalindrome(str, i, j, cache);

            if( i % 100 == 0 ) {
                System.out.println("처리중 Free Memory " + Runtime.getRuntime().freeMemory()/1024/1024 + "MB");
            }
        }

        System.out.println("처리중 Free Memory " + Runtime.getRuntime().freeMemory()/1024/1024 + "MB");

        int[] palindromeMin = new int[cache.length + 1];
        palindromeMin[0] = 0;

        for(int i=0; i<cache.length; i++) {
            int minCase = Integer.MAX_VALUE;

            for(int j=0; j <= i; j++) {
                if(cache[j][i-j] && minCase > palindromeMin[j]) minCase = palindromeMin[j];
            }



            palindromeMin[i+1] = (i==0) ? 1 : minCase + 1;
        }


        return palindromeMin[palindromeMin.length-1];
    }

    public static boolean isPalindrome(String str, int start, int end , Boolean[][] cache) {

        if(cache[start][end - start] != null) return cache[start][end - start];

        if(  start == end  ) {
            cache[start][end - start] = true;
            return true;
        }

        if (str.substring(start,start+1).equals(str.substring(end,end+1))) {
            if(start == end - 1) cache[start][end - start] = true;
            else cache[start][end - start] = isPalindrome(str, start+1, end-1, cache);
        }else{
            cache[start][end - start] = false;
        }

        return cache[start][end - start];
    }

}
