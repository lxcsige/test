package JVMTest;

/**
 * User: lxcfour
 * Date: 2018/5/12
 * Time: 下午5:56
 */
public class BigObjectTest {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation = new byte[4 * _1MB];
    }
}
