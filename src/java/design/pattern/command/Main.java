package design.pattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxucheng
 * @since 2023/1/28
 */
public class Main {

    public static void main(String[] args) {
        // select获取请求并封装为不同的Command对象
        List<Command> commands = new ArrayList<>();
        commands.add(new GotDiamondCommand(100));
        commands.add(new ArchiveCommand());
        for (Command command : commands) {
            command.execute();
        }
    }
}
