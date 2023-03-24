package oop.solid.ocp;

/**
 * @author liuxucheng
 * @since 2022/11/22
 */
public interface ServiceProvider {

    int getType();

    void service(User user);
}
