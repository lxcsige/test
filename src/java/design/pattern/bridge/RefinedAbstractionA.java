package design.pattern.bridge;

/**
 * @author liuxucheng
 * @since 2022/12/26
 */
public class RefinedAbstractionA extends Abstraction {

    public RefinedAbstractionA(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void operate() {
        System.out.println("AbstractionA");
        implementor.implement();
    }
}
