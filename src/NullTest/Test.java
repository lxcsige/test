package NullTest;

/**
 * Created by lxcfour on 16/8/18.
 */
public class Test {

    public static Object object1;

    public static void main(String[] args){
        String s = (String)null;
        Integer i = (Integer)null;
        Double d = (Double) null;
        System.out.println(s);
        System.out.println(i);
        System.out.println(d);
        System.out.println(object1);
    }
}
