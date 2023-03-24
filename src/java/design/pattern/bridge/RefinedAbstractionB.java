package design.pattern.bridge;

/**
 * @author liuxucheng
 * @since 2022/12/26
 */
public class RefinedAbstractionB extends Abstraction {

    public RefinedAbstractionB(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void operate() {
        System.out.println("AbstractionB");
        implementor.implement();
    }
}
