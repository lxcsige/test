package JVMTest;

import java.util.List;

/**
 * User: lxcfour
 * Date: 2018/5/12
 * Time: 下午6:09
 */
public class TenurePromotionTest {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }
}
