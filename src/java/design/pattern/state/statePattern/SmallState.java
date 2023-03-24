package design.pattern.state.statePattern;

import design.pattern.state.State;

/**
 * 小玛丽奥状态，单例模式
 *
 * @author liuxucheng
 * @since 2023/1/13
 */
public class SmallState implements IState {

    private SmallState() {

    }

    public static SmallState getInstance() {
        return SmallStateHolder.INSTANCE;
    }

    @Override
    public void obtainMushroom(StateMachine stateMachine) {
        // 状态：小 -> 超级
        stateMachine.setCurrentState(SuperState.getInstance());
        // 得分：+100
        stateMachine.setScore(stateMachine.getScore() + 100);
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
        // do nothing
    }

    @Override
    public State getState() {
        return State.SMALL;
    }

    private static class SmallStateHolder {

        private static final SmallState INSTANCE = new SmallState();
    }
}
