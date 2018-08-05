import java.util.Stack;

/*
 * Question:Coding Interview
 * 하노이의탑을 구현하고 최소 이동 횟수를 계산한다.
 */
public class 하노이의탑1 {
    public static void main(String arg[]) {
        int n = 3;
        Tower[] tower = new Tower[n];                
        for(int i=0;i<3;i++) tower[i] = new Tower(i+1);
        
        int diskCount = 3;
        for(int i=diskCount; i>0; i--) tower[0].add(i);
        
        Tower.moveDisks(diskCount, tower[0], tower[2], tower[1]);
        
        if(1==1) return;
        
    }
    
    static class Tower{
        private Stack<Integer> disks;
        private int index;
        public Tower(int idx) {
            disks = new Stack<>();
            this.index = idx;
        }
        
        public int index() {
            return index;
        }
        
        public void add (int d) {
            if(!disks.isEmpty() && disks.peek() <= d) {
                System.out.println("Error placing disk " + d);
            }else {
                disks.push(d);
            }
        }
        
        public void moveTopTo(Tower t) {
            int top = disks.pop();
            t.add(top);
            System.out.println("Move disk  [" + top + "] #" + index() + " -> #"+ t.index());            
        }
        
        public static void moveDisks(int n, Tower sorc, Tower dest, Tower buffer) {
            
            if(n > 0) {
                moveDisks(n - 1, sorc, buffer, dest);
                sorc.moveTopTo(dest);
                moveDisks(n - 1, buffer, dest, sorc);
            }
            
        }
    }
    
}
