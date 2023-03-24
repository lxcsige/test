package design.pattern.command;

/**
 * @author liuxucheng
 * @since 2023/1/28
 */
public class GotDiamondCommand implements Command {

    private int diamond;

    public GotDiamondCommand(int diamond) {
        this.diamond = diamond;
    }


    @Override
    public void execute() {
        System.out.println("GotDiamond");
    }
}
