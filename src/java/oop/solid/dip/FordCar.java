package oop.solid.dip;

/**
 * @author liuxucheng
 * @since 2022/11/22
 */
public class FordCar implements ICar {

    @Override
    public void run() {
        System.out.println("ford car run");
    }

    @Override
    public void turn() {
        System.out.println("ford car turn");
    }

    @Override
    public void stop() {
        System.out.println("ford car stop");
    }
}
