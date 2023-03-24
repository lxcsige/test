package oop.inheritance;

/**
 * @author liuxucheng
 * @since 2022/11/16
 */
public class Parent {

    private int a;

    public int b;

    private final int c = 10;

    public Parent(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }
}
