package ComputeIfAbsentTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * User: lxcfour
 * Date: 2018/8/20
 * Time: 下午4:49
 */
public class Test {
    public static void main(String[] args) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        map.putIfAbsent(1, set1);
        map.putIfAbsent(2, new HashSet<>());
        System.out.println(map.size());
    }
}
