import java.util.ArrayList;

/*
Question:Coding Interview
입력된 숫자들의 모든 부분집합을 구한다.
 */

public class 모든부분집합 {
    public static void main(String arg[]) {

        ArrayList<Integer> set = new ArrayList<Integer>();

        set.add(5);
        set.add(10);
        set.add(15);

        System.out.println(getSubsets(set,0));

    }

    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){


        ArrayList<ArrayList<Integer>> allsubsets;

        if( set.size() == index) {
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>());

        }else {

            allsubsets = getSubsets(set, index + 1);

            int item = set.get(index);

            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();

            for (ArrayList<Integer> subset : allsubsets) {
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset);
                newsubset.add(item);
                moresubsets.add(newsubset);

            }
            allsubsets.addAll(moresubsets);
        }

        return allsubsets;
    }



}
