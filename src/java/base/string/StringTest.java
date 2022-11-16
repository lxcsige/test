package base.string;

/**
 * @author liuxucheng
 * @since 2022/6/23
 */
public class StringTest {

    public static void main(String[] args) {
        String s1 = "s1";
        String s2 = s1.replace("s", "S");
        System.out.println(s1 == s2);

        String s3 = "a" + "b" + "c";
        String s4 = "abc";
        System.out.println(s3 == s4);

        final String s5 = "a";
        final String s6 = "b";
        String s7 = "ab";
        String s8 = s5 + s6;
        System.out.println(s7 == s8);

        String s9 = "a";
        String s10 = "b";
        String s11 = s9 + s10;
        String s12 = s9 + "b";
        System.out.println(s11 == s12);
    }
}
