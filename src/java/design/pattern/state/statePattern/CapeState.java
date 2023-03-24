package design.pattern.state.statePattern;

import design.pattern.state.State;

/**
 * 斗篷玛丽奥状态，单例模式
 *
 * @author liuxucheng
 * @since 2023/1/13
 */
public class CapeState implements IState {

    private CapeState() {

    }

    public static CapeState getInstance() {
        return CapeStateHolder.INSTANCE;
    }

    @Override
    public void obtainMushroom(StateMachine stateMachine) {
        // do nothing
    }

    @Override
    public void obtainFireFlower(StateMachine stateMachine) {
        // do nothing
    }

    @Override
    public void obtainCape(StateMachine stateMachine) {
        // do nothing
    }

    @Override
    public void meetMonster(StateMachine stateMachine) {
        // 状态：斗篷 -> 小
        stateMachine.setCurrentState(SmallState.getInstance());
        // 得分：-200
        stateMachine.setScore(stateMachine.getScore() - 200);
    }

    @Override
    public State getState() {
        return State.CAPE;
    }

    private static class CapeStateHolder {

        private static final CapeState INSTANCE = new CapeState();
    }
}
