import java.util.ArrayList;
/*
Question:
정렬_최대힙 (MinHeap) 구현

※ 참고
영단어 힙(heap)은 '무엇인가를 차곡차곡 쌓아올린 더미'라는 뜻을 지니고 있다. 힙은 항상 완전 이진 트리[1]의 형태를 띄어야 하고,
부모의 값은 항상 자식(들)의 값보다 크거나(Max heap 최대 힙), 작아야(Min heap 최소 힙)하는 규칙이 있다. 따라서 루트노드에는
항상 데이터들 중 가장 큰 값(혹은 가장 작은 값)이 저장되어 있기 때문에, 최댓값(혹은 최솟값)을 O(1)O(1)안에 찾을 수 있다.

단순히 최댓값(최솟값)을 O(1)O(1)안에 찾기 위해서라면 "항상 완전 이진 트리의 형태여야 한다"는 조건을 만족시킬 필요는 없다.
완전 이진 트리를 사용하는 이유는 삽입/삭제의 속도 때문이다. 물론 '힙 트리'는 정의상 완전 이진 트리를 사용하는 트리다. 달리 다른 구조를 사용한다
해도 전혀 얻을게 없는 최적의 구조이기 때문.
 */
public class 정렬_최대힙 {
    public static void main(String arg[]){

        MaxHeap heap = new MaxHeap();

        heap.insert(3);
        heap.insert(5);
        heap.insert(2);
        heap.insert(4);
        heap.insert(7);
		/*
		heap.insert(5); //4
		heap.insert(3); //2
		heap.insert(7); //5
		heap.insert(4); //3
		heap.insert(2); //1
		*/
        ArrayList<Integer> result = heap.sort();

        for(int item : result){
            System.out.println(item);
        }

    }
    static class MaxHeap {


        ArrayList<Integer> arr	;

        public MaxHeap(){

            arr  = new ArrayList<Integer>();

        }
        private void reheapUp(ArrayList<Integer> self, int idx){
            int parent = (idx - 1)  /2;

            if(self.get(idx) > self.get(parent)){
                int temp = self.get(idx);
                self.set(idx,    self.get(parent));
                self.set(parent, temp );

                if(parent > 0) reheapUp(self, parent);
            }
        }

        private void reheapDown(ArrayList<Integer> self, int idx){
            int left = 0;
            int right = 0;
            int large;

            if(idx * 2 + 1 < self.size()){
                left = self.get(idx * 2 + 1);

                if(idx * 2 + 2 < self.size() -1){
                    right = self.get(idx * 2 + 2);
                }

                if (left > right){
                    large = idx * 2 + 1;
                }else{
                    large = idx * 2 + 2;
                }
                System.out.println(idx);
                System.out.println(large);
                if(self.get(idx) < self.get(large)){

                    int temp = self.get(idx);
                    self.set(idx,    self.get(large));
                    self.set(large, temp );

                    reheapDown(self, large);
                }
            }

        }

        public void insert(int number){
            int last = this.arr.size();

            this.arr.add(number);

            if(number > 0) reheapUp(arr, last);

        }

        public int delete(){
            if(this.arr.size() == 0){
                return -1;
            }
            int del = this.arr.get(0);

            this.arr.set(0, this.arr.get(arr.size()-1));
            this.arr.remove(arr.size()-1);

            reheapDown(arr, 0);

            return del;
        }

        public ArrayList<Integer>  sort(){

            ArrayList<Integer> sort	= new ArrayList<Integer>();

            int count = this.arr.size();

            for(int i = 0; i < count ; i++){
                sort.add(this.delete());
            }
            return sort;

        }

    }

}
