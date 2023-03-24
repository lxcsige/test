package design.pattern.state.array;

import design.pattern.state.State;

import static design.pattern.state.State.*;

/**
 * @author liuxucheng
 * @since 2023/1/12
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

    public static final State[][] TRANSITIONS = {
            {SUPER, CAPE, FIRE, SMALL},
            {SUPER, CAPE, FIRE, SMALL},
            {CAPE, CAPE, CAPE, SMALL},
            {FIRE, FIRE, FIRE, SMALL}
    };

    public static final int[][] ACTIONS = {
            {+100, +200, +300, +0},
            {+0, +200, +300, -100},
            {+0, +0, +0, -200},
            {+0, +0, +0, -300}
    };

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
        executeEvent(Event.GOT_MUSHROOM);
    }

    /**
     * 获得斗篷
     *
     * 转移：小玛丽奥/超级玛丽奥 -> 斗篷玛丽奥
     * 动作：+200
     */
    public void obtainCape() {
        executeEvent(Event.GOT_CAPE);
    }

    /**
     * 获得火焰花
     *
     * 转移：小玛丽奥/超级玛丽奥 -> 火焰玛丽奥
     * 动作：+300
     */
    public void obtainFireFlower() {
        executeEvent(Event.GOT_FIRE);
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
        executeEvent(Event.MET_MONSTER);
    }

    private void executeEvent(Event event) {
        int currentStateValue = this.currentState.getValue();
        int eventValue = event.getValue();
        this.currentState = TRANSITIONS[currentStateValue][eventValue];
        this.score += ACTIONS[currentStateValue][eventValue];
    }

    public State getCurrentState() {
        return currentState;
    }

    public int getScore() {
        return score;
    }
}
