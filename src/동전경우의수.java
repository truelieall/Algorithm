
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
Question:백준알고리즘
문제
n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다. 이 동전들을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 그 경우의 수를 구하시오. (각각의 동전은 몇 개라도 사용할 수 있다.)

입력
첫째줄에 n, k가 주어진다. (1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000) 다음 n개의 줄에는 각각의 동전의 가치가 주어진다. 동전의 가치는 100,000보다 작거나 같은 자연수이다.
3 10
1
2
5


출력
첫째 줄에 경우의 수를 출력한다. 경우의 수는 2^31보다 작다.
 */

public class 동전경우의수 {

    public static void main(String arg[]) throws java.lang.Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String temp = br.readLine();

        String[] inputArr = temp.split(" ");

        int coinCount = Integer.valueOf(inputArr[0]);

        int targetAmt = Integer.valueOf(inputArr[1]);

        int[] coinArr = new int[coinCount];

        int minCoin = Integer.MAX_VALUE;

        for(int i=0; i< coinCount;i++) {
            coinArr[i] = Integer.valueOf(br.readLine());
            if (minCoin > coinArr[i]) minCoin = coinArr[i];
        }

        int result2 =   calcCoinCase2(coinArr, targetAmt) ;

        System.out.println("\n");
        System.out.println("=======TOTAL============================");
        System.out.println(result2);
        System.out.println("========================================");


    }

    public static int calcCoinCase2(int[] coinArr, int targetAmt) {

        int[] buffer2 = new int[targetAmt+1];

        buffer2[0]=1;

        int caseCount = 0;
        for(int i=0;i<coinArr.length;i++){
            for(int j=0;j<=targetAmt;j++){
                if(coinArr[i]<=j){
                    buffer2[j]+= buffer2[j-coinArr[i]];
                }
            }
        }

        return buffer2[targetAmt];
    }

}
