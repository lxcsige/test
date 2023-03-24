package design.pattern.template;

/**
 * @author liuxucheng
 * @since 2023/1/6
 */
public class Client {

    public static void main(String[] args) {
        AbstractClass clazz = new ConcreteClass1();
        // 复用模板方法，扩展抽象方法
        clazz.templateMethod();
    }
}
