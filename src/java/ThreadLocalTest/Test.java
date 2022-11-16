package ThreadLocalTest;

import java.text.SimpleDateFormat;

/**
 * User: lxcfour
 * Date: 2018/5/12
 * Time: 上午11:14
 */
public class Test {

    public static void main(String[] args) {
        ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>() {
            @Override
            public SimpleDateFormat initialValue() {
                return new SimpleDateFormat("yyyy-MM-dd");
            }
        };
    }
}
