package DecoratorTest;

/**
 * @author xucheng.liu
 * @date 2020/3/27
 */
public class Main {

    public static void main(String[] args) {
        NormalCar car = new NormalCar();
        car.move();

        System.out.println("----------------------------------");

        WaterCarDecorator waterCar = new WaterCarDecorator(car);
        waterCar.move();
    }
}
