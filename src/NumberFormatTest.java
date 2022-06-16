import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * @author xucheng.liu
 * @since 2022/1/12
 */
public class NumberFormatTest {

    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        numberFormat.setMaximumFractionDigits(0);
        numberFormat.setRoundingMode(RoundingMode.DOWN);
        System.out.println(numberFormat.format(0.2386));
    }
}
