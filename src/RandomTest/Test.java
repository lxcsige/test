package RandomTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by lxcfour on 16/7/20.
 */
public class Test {
    public static void main(String[] args){
        Random random1 = new Random(10);
        Random random2 = new Random(10);
        System.out.println(random1.nextInt());
        System.out.println(random2.nextInt());
        List<Integer> list = new ArrayList<>();
        list.add(1);
    }
}