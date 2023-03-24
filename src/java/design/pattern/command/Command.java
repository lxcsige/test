package design.pattern.command;

/**
 * 命令接口，封装命令和数据（类似于操作码和操作数）
 *
 * @author liuxucheng
 * @since 2023/1/28
 */
public interface Command {

    /**
     * 执行命令
     */
    void execute();
}
