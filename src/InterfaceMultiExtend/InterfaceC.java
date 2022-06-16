package InterfaceMultiExtend;

/**
 * 接口多继承，父接口中不能存在返回值不同但方法名和参数相同的方法
 *
 * @author xucheng.liu
 * @date 2021/4/8
 */
public interface InterfaceC extends InterfaceA, InterfaceB {

    void method2();
}
