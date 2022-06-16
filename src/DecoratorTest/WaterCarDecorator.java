package DecoratorTest;

/**
 * @author xucheng.liu
 * @date 2020/3/27
 */
public class WaterCarDecorator extends AbstractCarDecorator {

    public WaterCarDecorator(Car car) {
        super(car);
    }

    @Override
    public void move() {
        super.move();
        this.swim();
    }

    private void swim() {
        System.out.println("水上行驶");
    }
}
