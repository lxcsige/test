package design.pattern.prototype;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuxucheng
 * @since 2022/12/23
 */
public class CloneTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // 拷贝数组
        Coupon[] coupons = new Coupon[1];
        coupons[0] = new Coupon(0, 80, 0L, 0L);
        // 浅拷贝
        Coupon[] copiedCoupons = coupons.clone();

        // HashMap重写了clone方法，但仍然是浅拷贝
        HashMap<Integer, Coupon> couponMap = new HashMap<>();
        couponMap.put(coupons[0].getId(), coupons[0]);
        HashMap<Integer, Coupon> anotherCouponMap = (HashMap<Integer, Coupon>) couponMap.clone();
        Field table = couponMap.getClass().getDeclaredField("table");
        table.setAccessible(true);
        System.out.println(table.get(couponMap) == table.get(anotherCouponMap));
    }
}
