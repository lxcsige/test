package DecoratorTest;

/**
 * @author xucheng.liu
 * @date 2020/3/27
 */
public class AbstractCarDecorator implements Car {

    private Car car;

    public AbstractCarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}