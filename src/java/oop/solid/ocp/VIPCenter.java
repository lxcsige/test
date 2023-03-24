package oop.solid.ocp;

import java.util.List;
import java.util.Map;

/**
 * @author liuxucheng
 * @since 2022/11/22
 */
public class VIPCenter {

    private Map<Integer, ServiceProvider> providers;

    // 可以通过Spring Autowired注入
    public VIPCenter(List<ServiceProvider> providerList) {
        for (ServiceProvider serviceProvider : providerList) {
            providers.put(serviceProvider.getType(), serviceProvider);
        }
    }

    // 策略模式
    public void serviceVIP(User user) {
        providers.get(user.getType()).service(user);
    }
}
