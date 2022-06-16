package decimalFormatTest;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author xucheng.liu
 * @since 2021/5/24
 */
public class Test {

    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        System.out.println(decimalFormat.format(100000d));
        System.out.println(decimalFormat.format(10.00));
        System.out.println(decimalFormat.format(10.51));
        System.out.println(decimalFormat.format(0.0));

        DecimalFormat percentFormat = new DecimalFormat("0.0%");
        percentFormat.setRoundingMode(RoundingMode.HALF_UP);
        System.out.println(percentFormat.format(0.1612));
    }
}
