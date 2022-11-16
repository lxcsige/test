package base.string;

/**
 * @author liuxucheng
 * @since 2022/6/17
 */
public class StringBuilderTest {

    public static void main(String[] args) {
        // 默认
        StringBuilder sb1 = new StringBuilder();
        // capacity
        StringBuilder sb2 = new StringBuilder(32);
        // string
        String str = "abcabcabcabc";
        StringBuilder sb3 = new StringBuilder(str);
        // append null
        String str2 = null;
        System.out.println(sb1.append(str2));
        // delete
        System.out.println(sb3.delete(9, 12));
        // deleteCharAt
        System.out.println(sb3.deleteCharAt(8));
        // indexOf
        String str3 = "abc";
        System.out.println(sb3.indexOf(str3));
        System.out.println(sb3.indexOf(str3, 3));
        // lastIndexOf
        System.out.println(sb3.lastIndexOf(str3));
        // abcabcab
        System.out.println(sb3.lastIndexOf(str3, 4));
        // toString，String是不可变类，因此不能和StringBuilder共用char数组
        String sb3Str = sb3.toString();
        System.out.println(sb3Str);
    }
}
