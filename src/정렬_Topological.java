import java.util.LinkedList;
import java.util.Queue;
/*
Question:
Topological 정렬 구현
*/

public class 정렬_Topological {

    public static LinkedList<Integer> graph[];
    public static int n, indegree[];
    public static void main(String[] args) throws Exception{
		/*
		Scanner sc = new Scanner(System.in);
		String line[] = sc.nextLine().split(" ");
		*/
        int i, from, to, m;
        n = 8;//Integer.parseInt(line[0]);
        m = 9;//Integer.parseInt(line[1]);

        indegree = new int[n];
        graph = new LinkedList[n];

        for(i=0;i<n;i++) graph[i] = new LinkedList<>();

        graph[0].add(1);  indegree[1]++;
        graph[1].add(4);  indegree[4]++;
        graph[1].add(5);  indegree[5]++;
        graph[2].add(5);  indegree[5]++;
        graph[2].add(6);  indegree[6]++;
        graph[3].add(6);  indegree[6]++;
        graph[4].add(7);  indegree[7]++;
        graph[5].add(7);  indegree[7]++;
        graph[6].add(7);  indegree[7]++;

		/*
		for(i=0;i<m;i++){
			line = sc.nextLine().split(" ");
			from = Integer.parseInt(line[0]) - 1;
			to = Integer.parseInt(line[1]) - 1;

			graph[from].add(to);
			indegree[to]++;
		}
		*/

        topologicalSort();

        //sc.close();
    }

    private static void topologicalSort(){
        Queue<Integer> searchQ = new LinkedList<>();
        Queue<Integer> resultQ = new LinkedList<>();

        for(int i=0; i<n; i++){
            if(indegree[i]==0) searchQ.offer(i);
        }

        while(!searchQ.isEmpty()){
            int zeroIndegreeNode = searchQ.poll();
            resultQ.offer(zeroIndegreeNode);

            for(int linkedNode : graph[zeroIndegreeNode]){
                indegree[linkedNode]--;

                if(indegree[linkedNode]==0){
                    searchQ.offer(linkedNode);
                }
            }

        }

        while(!resultQ.isEmpty())
            System.out.print((resultQ.poll()+1) + " ");
    }
}
