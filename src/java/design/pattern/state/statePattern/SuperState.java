package design.pattern.state.statePattern;

import design.pattern.state.State;

/**
 * 超级玛丽奥状态，单例
 *
 * @author liuxucheng
 * @since 2023/1/13
 */
public class SuperState implements IState {

    private SuperState() {

    }

    public static SuperState getInstance() {
        return SuperStateHolder.INSTANCE;
    }

    @Override
    public void obtainMushroom(StateMachine stateMachine) {
        // do nothing
    }

    @Override
    public void obtainFireFlower(StateMachine stateMachine) {
        // 状态：小 -> 火焰
        stateMachine.setCurrentState(FireState.getInstance());
        // 得分：+300
        stateMachine.setScore(stateMachine.getScore() + 300);
    }

    @Override
    public void obtainCape(StateMachine stateMachine) {
        // 状态：小 -> 斗篷
        stateMachine.setCurrentState(CapeState.getInstance());
        // 得分：+200
        stateMachine.setScore(stateMachine.getScore() + 200);
    }

    @Override
    public void meetMonster(StateMachine stateMachine) {
        // 状态：超级 -> 小
        stateMachine.setCurrentState(SmallState.getInstance());
        // 得分：-100
        stateMachine.setScore(stateMachine.getScore() - 100);
    }

    @Override
    public State getState() {
        return State.SUPER;
    }

    private static class SuperStateHolder {

        private static final SuperState INSTANCE = new SuperState();
    }
}
