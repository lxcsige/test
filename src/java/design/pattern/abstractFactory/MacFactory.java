package design.pattern.abstractFactory;

/**
 * @author liuxucheng
 * @since 2022/12/22
 */
public class MacFactory implements Factory {

    @Override
    public Screen createScreen() {
        return new MacScreen();
    }

    @Override
    public KeyBoard createKeyBoard() {
        return new MacKeyBoard();
    }
}
