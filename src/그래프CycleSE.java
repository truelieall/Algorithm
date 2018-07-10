import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
Question:
그래프 노드와 루트를 입력 받아
Cycle이 존재하는지 판단한다.
단, 허용가능한 Depth를 입력받아 해당 Depth동안 Cycle이 없으면 없는걸로 판단한다.
(DFS) 방식 사용

입력
1라인 : 그래프 노드 갯수
그 이후 노드 갯수 만큼 라인 : 노드갯수만큼 반복 입력되며 위치에 따라 해당 노드로 갈수 있는 경로 유무
마지막라인 : 허용가능한 Depth 를 입력받는다.

예)
5
00101
00111
10001
01001
01100
3
*/
public class 그래프CycleSE {
    public static boolean isVisit[];
    public static void main (String[] args) throws java.lang.Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodeCount = Integer.parseInt(br.readLine());

        boolean[][] graph = new boolean[nodeCount][nodeCount];

        for(int i=0; i < nodeCount; i++){
            char[] inCharArr = br.readLine().toCharArray();

            for(int j=0; j < nodeCount; j++){
                if(inCharArr[j] == '0') graph[i][j] = false;
                else if (inCharArr[j] == '1') graph[i][j] = true;
            }
        }

        int cycleM = Integer.parseInt(br.readLine());

        if(!findCycle(graph, cycleM)) System.out.println("1");
        else System.out.println("0");
    }

    public static int mCount = 0;
    public static boolean findCycle(boolean[][] graph, int m){

        for(int i=0;i<graph.length; i++){
            System.out.println(i + " 로 시작");
            mCount = 0;
            isVisit = new boolean[graph.length];
            tempCount = new int[graph.length];
            if(!dfs(i, graph, m, i)){
                System.out.println("Cycle 존재");
                //return false;
            };
        }

        return true;
    }
    public static int tempCount[];
    public static boolean dfs(int v, boolean[][] graph, int m, int firstV){
        mCount++;
        isVisit[v] = true;
        System.out.println(v + " 방문");

        for (int i =0; i < graph[v].length; i++){
            if (i == v ) continue;
            if(graph[v][i] && isVisit[i]) {
                System.out.println(v + " : " + i + " 이미방문");
                if(firstV == i){
                    if(m == mCount) return false;

                }
            };

            if(graph[v][i] && !isVisit[i]){
                tempCount[v] = mCount;
                if(!dfs(i, graph, m, firstV)) return false;
                mCount = tempCount[v];
            };

        }

        return true;

    }

}
