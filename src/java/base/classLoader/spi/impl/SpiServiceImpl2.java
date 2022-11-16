package base.classLoader.spi.impl;

import base.classLoader.spi.SpiService;

/**
 * @author liuxucheng
 * @since 2022/6/21
 */
public class SpiServiceImpl2 implements SpiService {

    @Override
    public void execute() {
        System.out.println("SpiServiceImpl2");
    }
}
