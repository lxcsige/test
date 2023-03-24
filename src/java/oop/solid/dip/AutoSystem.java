package oop.solid.dip;

/**
 * @author liuxucheng
 * @since 2022/11/22
 */
public class AutoSystem {

    private ICar icar;

    public AutoSystem(ICar icar) {
        this.icar = icar;
    }

    public void run() {
        icar.run();
    }

    public void turn() {
        icar.turn();
    }

    public void stop() {
        icar.stop();
    }
}
