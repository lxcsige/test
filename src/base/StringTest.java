package base;

/**
 * string长度测试
 *
 * @author xucheng.liu
 * @since 2022/4/16
 */
public class StringTest {

    public static void main(String[] args) {
        String s1 = "𝄞";
        String s2 = "\uD834\uDD1E";
        System.out.println(s2);
        System.out.println(s1.length());
        System.out.println(s1.codePointCount(0, s1.length()));
    }
}
