package design.pattern.snapshot;

import java.util.Scanner;

/**
 * @author liuxucheng
 * @since 2023/1/28
 */
public class Main {

    public static void main(String[] args) {
        InputText inputText = new InputText();
        SnapshotHolder snapshotsHolder = new SnapshotHolder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equals(":list")) {
                System.out.println(inputText.getText());
            } else if (input.equals(":undo")) {
                // 弹出最近一次快照
                Snapshot snapshot = snapshotsHolder.popSnapshot();
                // 恢复快照
                inputText.restoreSnapshot(snapshot);
            } else {
                // 创建快照
                Snapshot snapshot = inputText.createSnapshot();
                // 保存快照
                snapshotsHolder.pushSnapshot(snapshot);
                // 追加最近一次输入
                inputText.append(input);
            }
        }
    }
}
