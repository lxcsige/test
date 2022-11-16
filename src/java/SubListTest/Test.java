package SubListTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lxcfour on 2016/12/19.
 */
public class Test {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1,2,3,4,5);
//        List<Integer> tmpList = list.stream().distinct().collect(Collectors.toList());
//        tmpList.subList(4, tmpList.size()).clear();
//        System.out.println(tmpList.size());

        StringBuilder s = new StringBuilder();
        for (int i = 0; i <= 255; i++) {
            s.append("一");
        }
        for (int j = 0; j <= 16; j++) {
            s.append("1");
        }
        System.out.println(s);
    }
}
