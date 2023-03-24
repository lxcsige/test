package design.pattern.chainOfResponsibility.linkedList;

/**
 * @author liuxucheng
 * @since 2023/1/9
 */
public abstract class Handler {

    private Handler successor;

    public final void handle() {
        doHandle();
        if (successor != null) {
            successor.handle();
        }
    }

    /**
     * 处理逻辑
     */
    public abstract void doHandle();

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}
