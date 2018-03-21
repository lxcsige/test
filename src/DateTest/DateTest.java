package DateTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lxcfour on 16/7/13.
 */
public class DateTest {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        System.out.println(date.getTime());

        Date date1 = new Date(1513060455155L);
        System.out.println(simpleDateFormat.format(date1));
    }

    private static void testLong(long l) {
        System.out.println(l);
    }

    private static void testLong(List<Long> list) {
        return;
    }
}
