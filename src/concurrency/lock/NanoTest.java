package concurrency.lock;

/**
 * @author xucheng.liu
 * @since 2022/4/25
 */
public class NanoTest {

    public static void main(String[] args) {
        System.out.println("milliTime: " + System.currentTimeMillis());
        // 返回的是任意时间，与时钟无关，不能表示一个时间戳，单位为纳秒，仅能用于衡量一段时间
        System.out.println("nanoTime: " + System.nanoTime());
    }
}
