package GenericTest;

import java.util.ArrayList;
import java.util.List;

/**
 * User: lxcfour
 * Date: 2018/3/14
 * Time: 下午8:42
 */
public class Test3 {

    public static void main(String[] args) {
//        List<Integer>[] li1 = new ArrayList<Integer>[10];
        List<?>[] li2 = new ArrayList<?>[10];
        li2[0] = new ArrayList<String>();
        List<?> v = li2[0];
    }
}
