package design.pattern.chainOfResponsibility.linkedList;

/**
 * @author liuxucheng
 * @since 2023/1/9
 */
public class Handler1 extends Handler {

    @Override
    public void doHandle() {
        System.out.println("handle 1");
    }
}
