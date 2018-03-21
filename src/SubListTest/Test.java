package SubListTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxcfour on 2016/12/19.
 */
public class Test {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list = list.subList(0, 1);
    }
}
