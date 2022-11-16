package base.classLoader.spi;

import java.util.ServiceLoader;

/**
 * @author liuxucheng
 * @since 2022/6/21
 */
public class Main {

    public static void main(String[] args) {
        ServiceLoader<SpiService> loader = ServiceLoader.load(SpiService.class);
        System.out.println("contextClassLoader = " + Thread.currentThread().getContextClassLoader());
        for (SpiService spiService : loader) {
            System.out.println("classLoader = " + spiService.getClass().getClassLoader());
            spiService.execute();
        }
    }
}
