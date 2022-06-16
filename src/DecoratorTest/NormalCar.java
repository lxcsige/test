package DecoratorTest;

/**
 * @author xucheng.liu
 * @date 2020/3/27
 *
 * 具体构件
 */
public class NormalCar implements Car {

    @Override
    public void move() {
        System.out.println("陆地行驶");
    }
}
