import java.util.ArrayList;
/*
Question:
DFS (Depth First Traversals) 깊이 우선탐색 방식의 그래프 순회
*/
public class 그래프DFS {

    public static int nodeCount = 7;

    public static void main(String arg[]){

        ArrayList<Integer>[] graph ;

        graph = new ArrayList[nodeCount];
        isVisit = new boolean[nodeCount];

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

        dfs(0, graph);
    }

    public static boolean isVisit[];

    public static void dfs(int v, ArrayList<Integer>[] graph){
        isVisit[v] = true;
        System.out.println(v+1 + " 방문");

        for (int i =0; i < graph[v].size(); i++){

            if (!isVisit[graph[v].get(i)]) dfs(graph[v].get(i), graph);

        }

    }
}
