package jmm;

/**
 * 重排序-异常测试
 *
 * @author xucheng.liu
 * @since 2022/4/14
 */
public class ReOrderTest {

    public static void main(String[] args) {
        int x, y;
        x = 1;
        try {
            // 为了保证最终不致于输出x = 1的错误结果，JIT在重排序时会在catch语句中插入错误代偿代码，将x赋值为2，将程序恢复到发生异常时应有的状态
            x = 2;
            y = 0 / 0;
        } catch (Exception e) {
        } finally {
            System.out.println("x = " + x);
        }
    }
}
