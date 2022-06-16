package NullTest;

/**
 * Created by lxcfour on 16/8/18.
 */
public class Test {

    public static Object object1;

    public static void main(String[] args){
        System.out.println(null instanceof Integer);
        System.out.println(Integer.valueOf(1).equals(null));
    }
}
