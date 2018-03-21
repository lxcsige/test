package GenericTest;

/**
 * Created by lxcfour on 16/7/27.
 */
public class Test {

    public static void main(String[] args){
        out("s");
        out(1);
        out(true);
    }

    public static <T> void out(T t){
        System.out.println(t);
    }
}
