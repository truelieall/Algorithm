import java.util.ArrayList;
import java.util.List;
/*
Question:
List 자료형에 List가 중첩해서 존재하는 구조에서의 순회
 */
public class 리스트재귀순회 {
    public static void main(String[] args) {
        List<Object> data = new ArrayList<Object>();

        data.add(1);

        data.add(2);

        data.add(3);

        List<Object> dataL1 = new ArrayList<Object>();
        dataL1.add(4);
        dataL1.add(5);

        List<Object> dataL2 = new ArrayList<Object>();
        dataL2.add(6);
        dataL2.add(8);

        dataL1.add(dataL2);

        data.add(dataL1);

        System.out.println(getList(data));
    }


    public static List getList(Object element) {

        List<Integer> returnList = new ArrayList<Integer>();

        if(element instanceof List) {
            for(Object el:(List) element) {
                returnList.addAll(getList(el));
            }
        }else {
            returnList.add((Integer) element);
        }

        return returnList;
    }
}
