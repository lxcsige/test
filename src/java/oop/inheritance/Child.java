package oop.inheritance;

/**
 * @author liuxucheng
 * @since 2022/11/16
 */
public class Child extends Parent {

    private int d;

    public Child() {
        super(1, 2);
        this.d = 4;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }
}
