import java.util.Arrays;
import java.util.Comparator;
/*
Question:
도시위치, 인구수 로 구성된 City 배열에서,
모두 모인다고 가정할때 가장 최소한의 인원이 이동할 수 있는 City 선정
 */

public class 최소이동City선정 {
    public static void main(String[] args)
    {
        TryHelloWorld test = new TryHelloWorld();

        int [][]tcity = {{2,2},{1,5},{3,3},{4,3},{5,3},{6,3},{7,3},{8,3}};
        //int [][]tcity = {{9,5},{5,2},{13,3},{2,4}};
        int tn = tcity.length;
        System.out.println(test.chooseCity(tn,tcity));
        System.out.println(test.chooseCity2(tn,tcity));
    }

    static class TryHelloWorld
    {
        public int chooseCity(int n, int [][]city)
        {
            int answerNo = 0;
            long answerDistsum = 0;

            int tempDistSum = 0;

            for(int i=0;i<n;i++){

                for(int j=0;j<n;j++){
                    if(j==i) continue;
                    tempDistSum += Math.abs((city[i][0] - city[j][0]) * city[j][1]);
                }

                System.out.println(city[i][0] + ":" + tempDistSum);

                if(  i==0
                        || (answerDistsum > tempDistSum)
                        || (answerDistsum == tempDistSum && answerNo > city[i][0])){

                    answerNo = city[i][0];
                    answerDistsum = tempDistSum;
                }

                tempDistSum = 0;
            }

            return answerNo;
        }

        public int chooseCity2(int n, int [][]city)
        {
            int answerNo = 0;

            Arrays.sort(city, new Comparator<int[]>() {
                public int compare(int[] arr1, int[] arr2) {
                    if( arr1[0] > arr2[0] )
                        return 1;
                    else
                        return -1;
                }
            });

            int right = 0;
            int left = 0;

            for(int i=0;i<n;i++) right += city[i][1];

            for(int i=0;i<n;i++){

                left += city[i][1];
                right -= city[i][1];

                if(left > right){
                    answerNo = city[i][0];
                    break;
                }

            }

            return answerNo;
        }

    }
}
