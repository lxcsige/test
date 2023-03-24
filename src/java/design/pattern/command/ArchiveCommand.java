package design.pattern.command;

/**
 * 归档命令
 *
 * @author liuxucheng
 * @since 2023/1/28
 */
public class ArchiveCommand implements Command {

    public ArchiveCommand() {

    }

    @Override
    public void execute() {
        System.out.println("Archive");
    }
}
