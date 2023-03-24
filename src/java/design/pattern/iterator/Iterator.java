package design.pattern.iterator;

/**
 * @author liuxucheng
 * @since 2023/1/13
 */
public interface Iterator<E> {

    /**
     * 是否有下一个元素
     *
     * @return
     */
    boolean hasNext();

    /**
     * 返回下一个元素
     *
     * @return
     */
    E next();

    /**
     * 删除最近一次返回的元素，在调用next方法后只能调用1次remove方法
     */
    default void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
