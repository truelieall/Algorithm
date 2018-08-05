import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
 * Question:Coding Interview
 * 하노이의탑을 구현하고 이동경로를 배열로 리턴한다.
 */
public class 하노이의탑2 {
    public static void main(String arg[]) {    
        System.out.println(Arrays.deepToString(solution(5)));
        
    }
    
    public static int[][] solution(int n) {
        
        int t = 3;
        Tower[] tower = new Tower[t];                
        for(int i=0;i<t;i++) tower[i] = new Tower(i+1);
        
        for(int i=n; i>0; i--) tower[0].add(i);
        
        List<Integer[]> pathList = new ArrayList<>();
        
        Tower.moveDisks(pathList, n, tower[0], tower[2], tower[1]);
        
        int[][] path = new int[pathList.size()][2];
        
        for(int i=0;i<pathList.size();i++) {
            path[i][0] = pathList.get(i)[0] ;
            path[i][1] = pathList.get(i)[1] ;
        }

        return path;
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
        
        public Integer[] moveTopTo(Tower t) {
            int top = disks.pop();
            t.add(top);            
            return new Integer[] {index(), t.index()}; 
        }
        
        public static void moveDisks(List<Integer[]> path, int n, Tower sorc, Tower dest, Tower buffer) {            
            
            if(n > 0) {
                moveDisks(path, n - 1, sorc, buffer, dest);
                path.add( sorc.moveTopTo(dest) );
                moveDisks(path, n - 1, buffer, dest, sorc);
            }            
            
        }
    }
    
}
