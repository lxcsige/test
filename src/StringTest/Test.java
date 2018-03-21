package StringTest;

/**
 * Created by lxcfour on 2017/10/26.
 */
public class Test {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        for (int i = 21109296; i < 21109496; i++) {
            sb.append(",").append(i);
        }
        System.out.println(sb.toString());
    }
}
