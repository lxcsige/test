package design.pattern.state.statePattern;

import design.pattern.state.State;

/**
 * @author liuxucheng
 * @since 2023/1/13
 */
public class StateMachine {

    /**
     * 当前状态，事件发生之后状态可能会转移，需要重新设置当前状态引用
     */
    private IState currentState;

    /**
     * 当前得分
     */
    private int score;

    /**
     * 构造函数，初始状态为小玛丽奥，初始得分为0
     */
    public StateMachine() {
        this.currentState = SmallState.getInstance();
        this.score = 0;
    }

    /**
     * 事件：获取蘑菇
     */
    public void obtainMushroom() {
        this.currentState.obtainMushroom(this);
    }

    /**
     * 事件：获取火焰
     */
    public void obtainFireFlower() {
        this.currentState.obtainFireFlower(this);
    }

    /**
     * 事件：获取斗篷
     */
    public void obtainCape() {
        this.currentState.obtainCape(this);
    }

    /**
     * 事件：碰到怪物
     */
    public void meetMonster() {
        this.currentState.meetMonster(this);
    }

    public State getCurrentState() {
        return this.currentState.getState();
    }

    public void setCurrentState(IState currentState) {
        this.currentState = currentState;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
