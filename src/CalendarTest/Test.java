package CalendarTest;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by lxcfour on 16/9/28.
 */
public class Test {

    public static void main(String[] args) {
        int result = BigDecimal.valueOf(28).multiply(BigDecimal.valueOf(90)).compareTo(BigDecimal.valueOf(25.2).multiply(BigDecimal.valueOf(100)));
        System.out.println(result);

        System.out.println(BigDecimal.valueOf(28f));
    }
}