package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xucheng.liu
 * @since 2021/8/4
 */
public class Test {

    private static final Pattern PATTERN = Pattern.compile("(\\d+?)(0*)");

    private static final Pattern PATTERN1 = Pattern.compile("([\\s\\u3000])+");

    public static void main(String[] args) {
        Matcher matcher = PATTERN.matcher("123000");
        if (matcher.matches()) {
            System.out.println("group1 = " + matcher.group(1));
            System.out.println("group2 = " + matcher.group(2));
        }

        Matcher matcher1 = PATTERN1.matcher("123\n 000");
        System.out.println("replaced = " + matcher1.replaceAll(" "));
    }
}
