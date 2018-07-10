
import java.util.HashMap;
import java.util.LinkedList;

/*
Question:
MRU(Most recently used) 캐쉬 구현
*/
public class 캐시구현_MRU {
    public static void main(String arg[]){
        int cacheSize = 5;

        MRUCache ltest = new MRUCache(cacheSize);

        ltest.set(1, "case11");
        ltest.set(2, 222);
        ltest.set(3, 333);
        ltest.set(4, 444);
        ltest.set(5, 555);


        ltest.get(2);
        ltest.get(5);
        ltest.get(3);

        ltest.set(6, 666);
        ltest.set(7, 777);
        ltest.set(9, "test9");
        ltest.set(7, 555);

        ltest.set(8, 888);

        for(int i=0; i<10; i++)
            System.out.println(i+1 + ":"+ ltest.get(i+1));
    }

    static class MRUCache {

        private int capacity;
        private HashMap<Object, Object> lookUp;
        private LinkedList<Object> nodes;

        public MRUCache(int capacity) {
            this.capacity = capacity;
            lookUp = new HashMap<Object, Object>();
            nodes = new LinkedList<Object>();
        }


        public Object get(Object key) {
            if (lookUp.get(key) == null) {
                return -1;
            } else {
                moveToFirst(key);
                return lookUp.get(key);
            }
        }


        private void moveToFirst(Object key){
            nodes.remove(key);
            nodes.addFirst(key);
        }

        private void moveToLast(Object key){
            nodes.remove(key);
            nodes.addLast(key);
        }

        public void set(int key, Object value) {

            if (lookUp.get(key) == null) {
                if (nodes.size() == capacity) {
                    lookUp.remove(nodes.removeFirst());
                }
                nodes.addLast(key);
            } else {
                moveToLast(key);
            }

            lookUp.put(key, value);

        }

    }

}
