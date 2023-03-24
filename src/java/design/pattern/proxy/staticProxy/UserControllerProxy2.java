package design.pattern.proxy.staticProxy;

/**
 * 无法改变被代理类的情况下使用继承
 * 无法对private、static和final方法进行代理
 *
 * @author liuxucheng
 * @since 2022/12/23
 */
public class UserControllerProxy2 extends UserController {

    private MetricCollector metricCollector;

    @Override
    public UserVO login(String telephone, String password) {
        metricCollector.record();
        return super.login(telephone, password);
    }

    @Override
    public UserVO register(String telephone, String password) {
        metricCollector.record();
        return super.register(telephone, password);
    }
}
