package design.pattern.bridge;

/**
 * @author liuxucheng
 * @since 2022/12/26
 */
public abstract class Abstraction {

    protected Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    /**
     * 操作方法
     */
    public abstract void operate();
}
