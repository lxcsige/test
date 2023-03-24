package design.pattern.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxucheng
 * @since 2022/12/23
 */
public class Client {

    public static void main(String[] args) {
        DeepCopy deepCopy = new DeepCopy();
        deepCopy.setA(1);
        deepCopy.setB(new int[]{1,2,3});
        Coupon coupon = new Coupon(2, 90, 10L, 11L);
        deepCopy.setC(coupon);
        List<Coupon> coupons = new ArrayList<>();
        coupons.add(coupon);
        deepCopy.setD(coupons);
        DeepCopy another = deepCopy.clone();
    }
}