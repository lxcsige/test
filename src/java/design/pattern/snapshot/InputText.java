package design.pattern.snapshot;

/**
 * @author liuxucheng
 * @since 2023/1/28
 */
public class InputText {

    private final StringBuilder text = new StringBuilder();

    public void append(String input) {
        text.append(input);
    }

    public String getText() {
        return text.toString();
    }

    /**
     * 创建快照
     *
     * @return
     */
    public Snapshot createSnapshot() {
        return new Snapshot(text.length());
    }

    /**
     * 恢复快照，仅支持撤销操作
     *
     * @param snapshot
     */
    public void restoreSnapshot(Snapshot snapshot) {
        this.text.delete(snapshot.getLen(), this.text.length());
    }
}
