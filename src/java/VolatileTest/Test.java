package VolatileTest;

/**
 * User: lxcfour
 * Date: 2018/4/16
 * Time: 下午5:28
 */
public class Test {

    private volatile int num = 1;

    public static void main(String[] args) {
        final Test test = new Test();
        test.num = 2;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
