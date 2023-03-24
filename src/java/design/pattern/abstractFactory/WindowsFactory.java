package design.pattern.abstractFactory;

/**
 * @author liuxucheng
 * @since 2022/12/22
 */
public class WindowsFactory implements Factory {

    @Override
    public Screen createScreen() {
        return new WindowsScreen();
    }

    @Override
    public KeyBoard createKeyBoard() {
        return new WindowsKeyBoard();
    }
}
