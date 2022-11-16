package InnerTest;

/**
 * Created by liuxucheng on 2018/2/26.
 */
public class OuterClass {

    public InnerClass getInnerClass (final int x) {
        final int y = 1;

        return new InnerClass() {
            @Override
            public int add() {
                int z = 2;
                return (x + y + z);
            }
        };
    }
}
