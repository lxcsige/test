package FinalTest;

/**
 * Created by lxcfour on 2017/11/13.
 */
public class Solution {

    public static void main(String[] args) {
        String s1 = "小明";
//        String s2 = "小" + "明";
//        System.out.println(s1 == s2);    //true
//
//        String str1 = "小";
//        String str2 = "明";
//        String s3 = str1 + str2;
//        System.out.println(s1 == s3);        //false

        //宏替换
        final String str3 = "小";
        final String str4 = "明";
        String s5 = str3 + str4;
        System.out.println(s1 == s5);
    }
}
