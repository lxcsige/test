package LocalDateTest;

import java.time.LocalDate;

/**
 * @author xucheng.liu
 * @since 2021/5/31
 */
public class Main {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("epochDay = " + localDate.toEpochDay());
    }
}
