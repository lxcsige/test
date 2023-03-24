package design.pattern.state.statePattern;

/**
 * @author liuxucheng
 * @since 2023/1/13
 */
public class Client {

    public static void main(String[] args) {
        StateMachine stateMachine = new StateMachine();
        // 获取蘑菇
        stateMachine.obtainMushroom();
        // 碰到怪物
        stateMachine.meetMonster();
    }
}
