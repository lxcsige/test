package design.pattern.state.branch;

import design.pattern.state.State;

/**
 * 玛丽奥状态机-分支法
 *
 * @author liuxucheng
 * @since 2023/1/11
 */
public class MarioStateMachine {

    /**
     * 当前状态
     */
    private State currentState;

    /**
     * 得分
     */
    private int score;

    /**
     * 初始状态为小玛丽奥，得分为0
     */
    public MarioStateMachine() {
        this.currentState = State.SMALL;
        this.score = 0;
    }

    /**
     * 获得蘑菇
     *
     * 转移：小玛丽奥 -> 超级玛丽奥
     * 动作：+100
     */
    public void obtainMushRoom() {
        if (currentState.equals(State.SMALL)) {
            this.currentState = State.SUPER;
            this.score += 100;
        }
    }

    /**
     * 获得斗篷
     *
     * 转移：小玛丽奥/超级玛丽奥 -> 斗篷玛丽奥
     * 动作：+200
     */
    public void obtainCape() {
        if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER) ) {
            this.currentState = State.CAPE;
            this.score += 200;
        }
    }

    /**
     * 获得火焰花
     *
     * 转移：小玛丽奥/超级玛丽奥 -> 火焰玛丽奥
     * 动作：+300
     */
    public void obtainFireFlower() {
        if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER) ) {
            this.currentState = State.FIRE;
            this.score += 300;
        }
    }

    /**
     * 碰到怪物
     *
     * 转移1：超级玛丽奥 -> 小玛丽奥
     * 动作1：-100
     *
     * 转移2：斗篷玛丽奥 -> 小玛丽奥
     * 动作2：-200
     *
     * 转移3：火焰玛丽奥 -> 小玛丽奥
     * 动作3：-300
     */
    public void meetMonster() {
        if (currentState.equals(State.SUPER)) {
            this.currentState = State.SMALL;
            this.score -= 100;
            return;
        }
        if (currentState.equals(State.CAPE)) {
            this.currentState = State.SMALL;
            this.score -= 200;
            return;
        }
        if (currentState.equals(State.FIRE)) {
            this.currentState = State.SMALL;
            this.score -= 300;
        }
    }

    public State getCurrentState() {
        return currentState;
    }

    public int getScore() {
        return score;
    }
}
