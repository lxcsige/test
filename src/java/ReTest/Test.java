package ReTest;

import java.util.regex.Pattern;

/**
 * Created by lxcfour on 2017/11/24.
 */
public class Test {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^.*/upload$", Pattern.CASE_INSENSITIVE);
        boolean result = pattern.matcher("/uploadImage").matches();
    }
}
