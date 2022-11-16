package base.object;

import java.util.Objects;

/**
 * @author liuxucheng
 * @since 2022/6/22
 */
public class HashCode {

    private int id;

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashCode parent = (HashCode) o;
        return id == parent.id && name.equals(parent.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
