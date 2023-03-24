package design.pattern.state.statePattern;

import design.pattern.state.State;

/**
 * 火焰玛丽奥状态，单例模式
 *
 * @author liuxucheng
 * @since 2023/1/13
 */
public class FireState implements IState {

    private FireState() {

    }

    public static FireState getInstance() {
        return FireStateHolder.INSTANCE;
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
        // 状态：火焰 -> 小
        stateMachine.setCurrentState(SmallState.getInstance());
        // 得分：-300
        stateMachine.setScore(stateMachine.getScore() - 300);
    }

    @Override
    public State getState() {
        return State.FIRE;
    }

    private static class FireStateHolder {

        private static final FireState INSTANCE = new FireState();
    }
}
