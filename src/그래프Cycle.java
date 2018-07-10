import java.util.ArrayList;
import java.util.HashSet;
/*
Question:
그래프 Cycle 찾기. (dfs)
*/

public class 그래프Cycle {
    public static int nodeCount = 7;
    public static HashSet<Integer> visitTargetSet;
    public static boolean isVisit[];

    public static void main(String arg[]){

        ArrayList<Integer>[] graph ;

        graph = new ArrayList[nodeCount];
        visitTargetSet = new HashSet<Integer>();
        isVisit = new boolean[nodeCount];

        for(int i=0;i<nodeCount;i++) graph[i] = new ArrayList<Integer>();
         /*
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
         */
        graph[0].add(1);
        graph[0].add(2);

        graph[1].add(0);
        graph[1].add(3);

        graph[2].add(0);
        graph[2].add(4);
        graph[2].add(5);

        graph[3].add(1);

        graph[4].add(2);
        //graph[4].add(5);

        graph[5].add(2);
        graph[5].add(4);

        graph[6].add(4);


        if(!dfs(0, graph))
            System.out.println("Cycle exists");
    }


    public static boolean dfs(int v, ArrayList<Integer>[] graph){
        isVisit[v] = true;
        System.out.println(v + " 방문");


        for (int i =0; i < graph[v].size(); i++)
            if (!isVisit[graph[v].get(i)]){
                if (visitTargetSet.contains(graph[v].get(i))) return false;
                else visitTargetSet.add(graph[v].get(i));
            };

        for (int i =0; i < graph[v].size(); i++){

            if(isVisit[graph[v].get(i)]) continue;

            if(!dfs(graph[v].get(i), graph)) return false;
        }
        return true;

    }
}
