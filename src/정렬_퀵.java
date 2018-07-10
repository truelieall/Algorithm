import java.util.Arrays;

/*
Question:
Quick 정렬 구현
*/
public class 정렬_퀵 {

    public static void main(String args[]) {
        int A[] = {-3, 1, 2,19,-2, 5, 6, 7 ,16, 17, 18, 20} ;
        //int A[] = {-5, 5, -5, 4};
        //int A[] = {-3, 1, 2,5,-2, 19, 6, 7 ,16, 17, 18, 20} ;
        System.out.println(new QuickSort().solution(A));

    }
    static class QuickSort {

        public int solution(int[] A) {

            quickSort(A, 0, A.length-1);
            System.out.println(Arrays.toString(A));
            return 0;
        }

        public void quickSort(int[] arr, int left, int right){

            int index = partition (arr, left, right);
            if(left < index -1) {
                quickSort(arr, left, index-1);
            }
            if (index < right){
                quickSort(arr, index, right);
            }
        }

        public int partition (int[] arr, int left, int right){
            int pivot = arr[(left + right) /2];
            while (left <= right){
                while (arr[left] < pivot) left++;
                while (arr[right] > pivot) right--;

                if (left <= right){
                    int temp;
                    temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    left++;
                    right--;
                }
            }
            return left;
        }
    }
}
