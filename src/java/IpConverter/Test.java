package IpConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuxucheng on 2018/5/10.
 */
public class Test {

    public static void main(String[] args) {
        Solution test = new Solution();
        Map<String, Long> inputMap = new HashMap<>();

        // 合法ip
        inputMap.put("172.168.5.1", 2896692481L);
        inputMap.put("172.168 .5.1", 2896692481L);
        inputMap.put("172 .168 .5. 1", 2896692481L);
        inputMap.put("172 . 168.5.1", 2896692481L);
        inputMap.put("  172  .  168.5.1", 2896692481L);

        // 不合法ip
        inputMap.put("172.00.5.1", -1L);
        inputMap.put("172.01.5.1", -1L);
        inputMap.put("-1.168.5.1", -1L);
        inputMap.put("256.168.5.1", -1L);
        inputMap.put("17 2.168.5.1", -1L);
        inputMap.put("17  2.168.5.1", -1L);
        inputMap.put("172..5.1", -1L);
        inputMap.put(".168.5.1", -1L);
        inputMap.put(" .168.5.1", -1L);
        inputMap.put("172.168.5.", -1L);
        inputMap.put("172.168.5", -1L);
        inputMap.put("172.168.5.1.1", -1L);

        for (Map.Entry<String, Long> entry : inputMap.entrySet()) {
            long res = test.ip2Long(entry.getKey());
            if (res != entry.getValue()) {
                System.out.println("ip string: " + entry.getKey());
            }
        }
    }
}
