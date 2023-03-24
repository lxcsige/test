package oop.solid.ocp;

/**
 * @author liuxucheng
 * @since 2022/11/22
 */
public class SlumDogVIPServiceProvider implements ServiceProvider {

    @Override
    public int getType() {
        return UserTypeEnum.SLUM_DOG_VIP.getType();
    }

    @Override
    public void service(User user) {
        System.out.println("SlumDogVIP");
    }
}
