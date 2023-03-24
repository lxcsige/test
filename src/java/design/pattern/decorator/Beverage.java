package design.pattern.decorator;

/**
 * 饮料接口
 *
 * @author liuxucheng
 * @since 2022/12/26
 */
public interface Beverage {

    /**
     * 名称
     *
     * @return
     */
    String description();

    /**
     * 价格
     *
     * @return
     */
    double cost();

    /**
     * 几分糖
     *
     * @return
     */
    int sugar();
}
