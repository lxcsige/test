package design.pattern.snapshot;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liuxucheng
 * @since 2023/1/28
 */
public class SnapshotHolder {

    /**
     * 保存每次操作前的快照
     */
    private Deque<Snapshot> snapshots = new LinkedList<>();

    /**
     * 弹出最近一次快照
     *
     * @return
     */
    public Snapshot popSnapshot() {
        return snapshots.pop();
    }

    /**
     * 添加快照
     *
     * @param snapshot
     */
    public void pushSnapshot(Snapshot snapshot) {
        snapshots.push(snapshot);
    }
}
