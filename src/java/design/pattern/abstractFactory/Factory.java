package design.pattern.abstractFactory;

/**
 * 工厂接口，同一工厂生产出来的对象属于同一产品族
 * 产品族：一系列相关的对象，比如MacScreen和MacKeyBoard
 * 产品等级结构：同一继承结构中的对象，比如MacScreen和WindowsScreen
 *
 * @author liuxucheng
 * @since 2022/12/22
 */
public interface Factory {

    Screen createScreen();

    KeyBoard createKeyBoard();
}
