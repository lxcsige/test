package design.pattern.snapshot;

/**
 * 快照类，不对外暴露set方法
 *
 * @author liuxucheng
 * @since 2023/1/28
 */
public class Snapshot {

    /**
     * 文本长度
     */
    private final int len;

    public Snapshot(int len) {
        this.len = len;
    }

    public int getLen() {
        return this.len;
    }
}
