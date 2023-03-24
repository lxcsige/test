package design.pattern.builder;

/**
 * @author liuxucheng
 * @since 2022/12/22
 */
public class Client {

    public static void main(String[] args) {
        ResourcePoolConfig config = ResourcePoolConfig.builder()
                .name("")
                .maxTotal(10)
                .maxIdle(10)
                .minIdle(5)
                .build();
    }
}
