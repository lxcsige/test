package design.pattern.state.statePattern;

import design.pattern.state.State;

/**
 * 状态接口
 *
 * @author liuxucheng
 * @since 2023/1/13
 */
public interface IState {

    /**
     * 事件：获得蘑菇
     *
     * @param stateMachine
     */
    void obtainMushroom(StateMachine stateMachine);

    /**
     * 事件：获得火焰花
     *
     * @param stateMachine
     */
    void obtainFireFlower(StateMachine stateMachine);

    /**
     * 事件：获得斗篷
     *
     * @param stateMachine
     */
    void obtainCape(StateMachine stateMachine);

    /**
     * 事件：碰到怪物
     *
     * @param stateMachine
     */
    void meetMonster(StateMachine stateMachine);

    /**
     * 获取状态
     *
     * @return
     */
    State getState();
}
