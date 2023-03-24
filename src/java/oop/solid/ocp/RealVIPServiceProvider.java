package oop.solid.ocp;

/**
 * @author liuxucheng
 * @since 2022/11/22
 */
public class RealVIPServiceProvider implements ServiceProvider {

    @Override
    public int getType() {
        return UserTypeEnum.REAL_VIP.getType();
    }

    @Override
    public void service(User user) {
        System.out.println("RealVIP");
    }
}
