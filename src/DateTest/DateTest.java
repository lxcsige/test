package DateTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by lxcfour on 16/7/13.
 */
public class DateTest {

    public static void main(String[] args) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        int monthNum = (calendar.get(Calendar.YEAR) - 1970) * 12 + calendar.get(Calendar.MONTH);
        System.out.println(monthNum);

        List<Date> res = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date tmpDate = dateFormat.parse("1970-01-01");
        Calendar cal = Calendar.getInstance();
        cal.setTime(tmpDate);
        cal.add(Calendar.MONTH, monthNum);
        System.out.println(cal.getTime());

        Date date = new Date();
        System.out.println((int)(date.getTime() / 86400000));
    }

    private static void testLong(long l) {
        System.out.println(l);
    }

    private static void testLong(List<Long> list) {
        return;
    }
}
