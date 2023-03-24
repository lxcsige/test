package design.pattern.iterator;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * ArrayList迭代器
 *
 * @author liuxucheng
 * @since 2023/1/13
 */
public class ArrayListIterator<E> implements Iterator<E> {

    /**
     * 下一个元素的index
     */
    private int cursor;

    /**
     * 上一次返回的cursor，用于remove方法
     */
    private int lastRet = -1;

    private final ArrayList<E> arrayList;

    public ArrayListIterator(ArrayList<E> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public boolean hasNext() {
        // cursor表示下一个元素的index
        // 当cursor指向最后一个元素时，hasNext()仍然返回true
        return cursor < arrayList.size();
    }

    @Override
    public E next() {
        if (cursor >= arrayList.size()) {
            throw new NoSuchElementException();
        }
        lastRet = cursor;
        cursor++;
        return arrayList.get(lastRet);
    }

    @Override
    public void remove() {
        if (lastRet < 0) {
            throw new IllegalStateException();
        }
        arrayList.remove(lastRet);
        // 1次next方法后调用多次remove会抛异常
        lastRet = -1;
    }
}
