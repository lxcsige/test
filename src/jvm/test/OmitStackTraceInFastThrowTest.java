package jvm.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 内置
 *
 * @author xucheng.liu
 * @since 2021/7/20
 */
public class OmitStackTraceInFastThrowTest {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        int counter = 0;
        while (true) {
            counter++;
            try {
                int a = map.get("test");
            } catch (Exception e) {
                if (e.getStackTrace() == null || e.getStackTrace().length == 0) {
                    System.out.println("counter = " + counter);
                    e.printStackTrace();
                    return;
                }
            }
        }
    }
}
