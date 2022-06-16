package InheritTest;

/**
 * @author xucheng.liu
 * @date 2020/3/27
 */
public class City extends Country {

    @Override
    public void value() {
        super.value();
    }

    public static void main(String[] args) {
        City city = new City();
        city.value();
        System.out.println(city.getName());
    }
}
