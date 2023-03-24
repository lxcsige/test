package design.pattern.state;

/**
 * 超级玛丽状态枚举
 *
 * @author liuxucheng
 * @since 2023/1/11
 */
public enum State {
    /**
     * 小玛丽奥
     */
    SMALL(0),
    /**
     * 超级玛丽奥
     */
    SUPER(1),
    /**
     * 火焰玛丽奥
     */
    FIRE(2),
    /**
     * 斗篷玛丽奥
     */
    CAPE(3),
    ;

    private int value;

    State(int value) {
        this.value = value;
    }

    public int getValue() { return this.value; }
}
