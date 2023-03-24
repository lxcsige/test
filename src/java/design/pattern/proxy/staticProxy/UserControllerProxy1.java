package design.pattern.proxy.staticProxy;

/**
 * 接口+组合实现静态代理类
 *
 * @author liuxucheng
 * @since 2022/12/23
 */
public class UserControllerProxy1 implements IUserController {

    private IUserController userController;

    private MetricCollector metricCollector;

    /**
     * 依赖注入
     *
     * @param userController
     */
    public UserControllerProxy1(IUserController userController) {
        this.userController = userController;
    }

    @Override
    public UserVO login(String telephone, String password) {
        // 功能增强
        metricCollector.record();
        return userController.login(telephone, password);
    }

    @Override
    public UserVO register(String telephone, String password) {
        metricCollector.record();
        return userController.register(telephone, password);
    }
}
