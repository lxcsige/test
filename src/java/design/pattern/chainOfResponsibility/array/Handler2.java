package design.pattern.chainOfResponsibility.array;

/**
 * @author liuxucheng
 * @since 2023/1/9
 */
public class Handler2 implements Handler {

    @Override
    public void handle() {
        System.out.println("handle 2");
    }
}
