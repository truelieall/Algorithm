import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
/*
Question:
BFS (Breadth First Traversal) 넓이 우선탐색 방식의 그래프 순회

*/
public class 그래프BFS {

    public static int nodeCount = 7;
    public static boolean isVisit[];
    public static Queue<Integer> stQ;

    public static void main(String arg[]){

        ArrayList<Integer>[] graph ;

        graph = new ArrayList[nodeCount];
        isVisit = new boolean[nodeCount];
        stQ = new ArrayDeque<Integer>();

        for(int i=0;i<nodeCount;i++) graph[i] = new ArrayList<Integer>();

        graph[0].add(1);
        graph[0].add(2);
        graph[1].add(3);
        graph[1].add(4);
        graph[2].add(3);
        graph[2].add(5);
        graph[3].add(4);
        graph[3].add(6);
        graph[4].add(6);
        graph[5].add(6);

        bfs(0, graph);
    }

    public static void bfs(int v, ArrayList<Integer>[] graph){
        isVisit[v] = true;
        stQ.add(v);

        System.out.println(v+1 + " done");

        while(!stQ.isEmpty()){

            v = stQ.poll();
            for (int i =0; i < graph[v].size(); i++){
                if (!isVisit[graph[v].get(i)]) {
                    stQ.add(graph[v].get(i));
                    isVisit[graph[v].get(i)] = true;
                    System.out.println(graph[v].get(i)+1 + " done");
                }
            }

        }

    }
}
