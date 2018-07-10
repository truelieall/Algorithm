import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
Question:
memcpy를 구현한다.
※ 255값의 표현에 주의한다. (& 0xff)

입력
1라인 : array Size
2라인 : 입력 스트링은 255까지의 숫자들로 구성된 배열
3라인 : int dest, int src, int size

10
1 2 5 10 232 30 50 55 255 -1
2 6 3

10
1 2 5 10 232 30 50 55 255 20
2 6 3

*/
public class memcpy구현 {
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int arrSize = Integer.parseInt(br.readLine());

        String[] inStrArr2 = br.readLine().split(" ");

        byte[] inArr = new byte[arrSize];

        for(int i=0; i < arrSize; i++){
            int tempIntVal = Integer.parseInt(inStrArr2[i]);
            if(tempIntVal < 0) return; //do nothing
            inArr[i] = (byte) tempIntVal;
        }

        String[] inStrArr3 = br.readLine().split(" ");
        int inDest = Integer.parseInt(inStrArr3[0]);
        int inSrc = Integer.parseInt(inStrArr3[1]);
        int inSize = Integer.parseInt(inStrArr3[2]);

        if (   inDest < 0
                || inSrc  < 0
                || inSize <= 0){
            for(int i=0; i < arrSize; i++) System.out.print(inStrArr2[i] + " ");
            return;
        }

        memcpy(inArr, inDest, inSrc, inSize);

        for(int i=0; i < arrSize; i++){
            System.out.print((inArr[i] & 0xff) + " ");
        }
    }

    public static void memcpy(byte[] v, int dest, int src, int size) {
        for(int i=0; i<size; i++){
            v[dest + i] = v[src + i];
        }
    }
}
