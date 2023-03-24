package design.pattern.prototype;

import java.io.*;
import java.util.List;

/**
 * @author liuxucheng
 * @since 2022/12/23
 */
public class DeepCopy implements Cloneable, Serializable {

    private int a;

    private int[] b;

    private Coupon c;

    private List<Coupon> d;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int[] getB() {
        return b;
    }

    public void setB(int[] b) {
        this.b = b;
    }

    public Coupon getC() {
        return c;
    }

    public void setC(Coupon c) {
        this.c = c;
    }

    public List<Coupon> getD() {
        return d;
    }

    public void setD(List<Coupon> d) {
        this.d = d;
    }

    @Override
    public DeepCopy clone() {
        Object copied = null;
        try {
            // 序列化
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(this);

            // 反序列化
            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(bi);
            copied = oi.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (DeepCopy) copied;
    }
}
