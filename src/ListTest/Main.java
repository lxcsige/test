package ListTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xucheng.liu
 * @date 2019/8/12
 */
public class Main {

    public static void main(String[] args) {
        Map<Integer, Creature> map = new HashMap<>();
        map.put(1, new Plant());
        map.put(2, new Animal());
    }
}
