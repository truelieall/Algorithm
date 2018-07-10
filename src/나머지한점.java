import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/*
Question:Programmers
입력된 int 배열에는 3개의 좌표가 들어있다.
직사각형의 각 변은 x 혹은 y축과 평행일때,
나머지 1개의 좌표를 찾는다.
(hashset 을 이용해 해결, XOR(^)을 이용해서도 해결 가능 예상
 */
public class 나머지한점 {
    public int[] solution(int[][] v) {
        int[] answer = {};
        Set<Integer> pointX = new HashSet<>();
        Set<Integer> pointY = new HashSet<>();

        for(int[] point : v){
            if(pointX.contains(point[0])) pointX.remove(point[0]);
            else pointX.add(point[0]);

            if(pointY.contains(point[1])) pointY.remove(point[1]);
            else pointY.add(point[1]);
        }

        return new int[]{pointX.iterator().next(), pointY.iterator().next()};
    }

    public static void main(String[] args) {
        int [][] v = new int[3][2];
        v[0] = new int[]{1,4};
        v[1] = new int[]{3,4};
        v[2] = new int[]{3,10};

        int [][] v2 = new int[3][2];
        v2[0] = new int[]{3,3};
        v2[1] = new int[]{4,4};
        v2[2] = new int[]{3,4};

        System.out.println(Arrays.toString( new 나머지한점().solution(v2) ));

        System.out.println(Arrays.toString( new 나머지한점().solution(v2) ));

    }
}
