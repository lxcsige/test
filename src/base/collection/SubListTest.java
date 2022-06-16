package base.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xucheng.liu
 * @since 2022/6/9
 */
public class SubListTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> subList = list.subList(1,1);
        System.out.println(subList.size());
    }
}
