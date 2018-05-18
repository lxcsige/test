package BigDecimalTest;

import java.math.BigDecimal;

/**
 * Created by lxcfour on 16/8/1.
 */
public class Test {

    public static int i = 0;

    public static int j;

    static {
        j = 1;
    }

    public static void main(String[] args){
        BigDecimal bigDecimal1 = new BigDecimal(Double.toString(0.123d));
        System.out.println(bigDecimal1.doubleValue());
    }
}
