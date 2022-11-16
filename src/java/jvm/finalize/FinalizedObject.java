package jvm.finalize;

/**
 * @author liuxucheng
 * @since 2022/8/30
 */
public class FinalizedObject {

    @Override
    public void finalize() {
        System.out.println("finalize");
    }
}
