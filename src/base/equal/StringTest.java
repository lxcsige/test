package base.equal;

/**
 *
 * @author lxcfour
 * @date 2017/10/26
 */
public class StringTest {

    public static void main(String[] args) {
        // a 为一个引用
        String a = new String(String.valueOf(11));
        // b为另一个引用，对象的内容一样
        String b = new String(String.valueOf(11));
        String c = b.intern();
        // 此时字符串"aa"也会进入常量池
        String d = new String("aa");
        String e = d.intern();
        // 放在常量池中
        String aa = "11";
        // 从常量池中查找
        String bb = "12";

        // false
        System.out.println("a == b: " + (a == b));
        // true
        System.out.println("b == c: " + (b == c));
        // false
        System.out.println("d == e: " + (d == e));
        // true
        System.out.println("c == aa: " + (c == aa));
        // false
        System.out.println("aa == bb: " + (aa == bb));

        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        // 编译期优化
        String s4 = "javaEE" + "hadoop";

        // 如果拼接符号的前后出现了变量，则相当于在堆空间中new String()，具体的内容为拼接的结果：javaEEhadoop
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        // true
        System.out.println(s3 == s4);
        // false
        System.out.println(s3 == s5);
        // false
        System.out.println(s3 == s6);
        // false
        System.out.println(s3 == s7);
        // false
        System.out.println(s5 == s6);
        // false
        System.out.println(s5 == s7);
        // false
        System.out.println(s6 == s7);

        String ss1 = "12";
        String ss2 = String.valueOf(12);
        // false
        System.out.println("ss1 == ss2: " + (ss1 == ss2));
    }
}
