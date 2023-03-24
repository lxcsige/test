package design.pattern.state.array;

/**
 * 玛丽奥事件枚举
 *
 * @author liuxucheng
 * @since 2023/1/12
 */
public enum Event {

    /**
     * 获取蘑菇事件
     */
    GOT_MUSHROOM(0),
    /**
     * 获取斗篷事件
     */
    GOT_CAPE(1),
    /**
     * 获取火焰事件
     */
    GOT_FIRE(2),
    /**
     * 碰到怪物事件
     */
    MET_MONSTER(3);

    private int value;

    Event(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
