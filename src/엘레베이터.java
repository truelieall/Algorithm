import java.util.HashSet;
import java.util.Set;

/*
Question:
엘레베이터의 stop 횟수를 카운트하는 펑션 구현 (항상 1층으로 복귀)
무게 및 최대 탑승인원이 제한 되어 있다.

createElevator(int[] A, int[] B, int M, int X, int Y)
A = 탑승인원의 몸무게를 담고 있는 배열
B = A에 해당하는 인원들이 이동하려는 층번호
M = 해당 건물의 층수
X = 엘레베이터 최대 탑승 가능 인원
Y = 엘레베이터 최대 탑승 가능 무게
 */

public class 엘레베이터 {

    public static void main(String arg[]) {

        System.out.println(createElevator(new int[] {60,80,40}, new int[] {2,3,5}, 5, 2, 200));

        System.out.println(createElevator(new int[] {40, 40, 100, 80, 20}, new int[] {3, 3, 2, 2, 3}, 3, 5, 200));

        System.out.println(createElevator(new int[] {40, 40, 100, 200, 20}, new int[] {3, 3, 2, 2, 3}, 3, 5, 200));

        System.out.println(createElevator(new int[] {40, 40, 100, 200, 20}, new int[] {3, 3, 2, 2, 3}, 3, 1, 200));

    }

    public static int createElevator(int[] A, int[] B, int M, int X, int Y) {

        Elevator elevator = new Elevator(M, X, Y);

        int peopleCount = A.length;
        int totalStep = 0;

        for(int i=0; i < peopleCount; i++) {

            boolean isDone = elevator.addPeople(A[i], B[i]);

            if(!isDone) {
                totalStep += elevator.doTask();
                elevator.addPeople(A[i], B[i]);
            };
        }

        totalStep += elevator.doTask();

        return totalStep;
    }

    static class Elevator{
        Set<Integer> taskList;

        int limitWeight;
        int currWeight;

        int maxPeople;
        int currPeople;

        int floors;

        public Elevator(int floors, int maxPeople, int limitWeight) {

            this.floors = floors;
            this.maxPeople = maxPeople;
            this.limitWeight = limitWeight;
            this.currWeight = 0;
            this.currPeople = 0;
            taskList = new HashSet<>();
        }

        public boolean addPeople(int weight, int target) {

            if(currWeight + weight > limitWeight) return false;

            if(currPeople + 1 > maxPeople) return false;

            this.currWeight += weight;
            currPeople++;

            taskList.add(target);

            return true;
        }

        public int doTask() {

            int taskCount = taskList.size() + 1;

            taskList.clear();
            currWeight = 0;
            currPeople = 0;

            return taskCount;
        }

    }
}
