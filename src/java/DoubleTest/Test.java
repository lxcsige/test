package DoubleTest;

import java.math.BigDecimal;

/**
 * Created by lxcfour on 16/8/1.
 */
public class Test {

    public static void main(String[] args){
        float f1 = 0.99999999f;
        float f2 = 1f;
        boolean value = (Float.floatToIntBits(f1) == Float.floatToIntBits(f2));
        System.out.println(value);
        System.out.println(Float.compare(f1, f2));

        double a = 112 / 100.0;

        System.out.println(0.06 + 0.01);
        System.out.println(1.0 - 0.42);
        System.out.println(4.015 * 100);
        System.out.println(303.1 / 1000);
        System.out.println("a = " + a);

        BigDecimal bigDecimal1 = new BigDecimal(Float.toString(f1));
        BigDecimal bigDecimal = new BigDecimal(f1 + "");
        BigDecimal bigDecimal2 = new BigDecimal(Float.toString(f2));
        System.out.println(bigDecimal1.compareTo(bigDecimal2));

    }
}
