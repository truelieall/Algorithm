import java.math.BigInteger;
/*
  Question :
  2진수로 이루어진 스트링을 입력 받아,
  짝수 일경우 2나누고 홀수 일 경우 1을 뺀다.
  해당 작업을 반복해서 0이되는 횟수를 계산 한다.
 */
public class 이진스트링SUBORDIV {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<100000;i++) {
            sb.append("01");
        }

        System.out.println(subtractOrDivide(sb.toString()));
    }
    public static int subtractOrDivide(String S) {

        char[] inChars = S.toCharArray();
        long number = 0;
        BigInteger num = new BigInteger(S,2);

        for(int i=1; i<inChars.length; i++ ) {

            if(inChars[i] == '1') number += Math.pow(2, inChars.length - 1 - i);
            else if(inChars[i] == '0') continue;
            else throw new IllegalArgumentException("Illegal character : " + i + "-" + inChars[i]);
        }

        System.out.println(num);
        System.out.println(number);

        int countStep = 0;

        while(number != 0) {
            countStep++;
            if(number%2==0) number = number / 2;
            else  number = number - 1;
        }
        int countStep2 = 0;
        BigInteger num2 = new BigInteger("2");

        while(!num.equals(BigInteger.ZERO)) {
            countStep2++;

            if(num.mod(num2).equals(BigInteger.ZERO)) num = num.divide(num2);

            else  num = num.subtract(BigInteger.ONE);

            if(countStep2%100==0) {
                System.out.println("######" + String.format("%8d", countStep2) + "######");
            }
        }
        System.out.println(countStep2);

        return countStep;
    }

}
