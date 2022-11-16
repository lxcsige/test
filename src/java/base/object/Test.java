package base.object;

/**
 * @author liuxucheng
 * @since 2022/6/22
 */
public class Test {

    public static void main(String[] args) {
        HashCode hashCode = new HashCode();
        System.out.println(System.identityHashCode(hashCode));
        System.out.println(hashCode.hashCode());
    }
}
