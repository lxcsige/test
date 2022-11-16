package jvm.safepoint;

/**
 * @author liuxucheng
 * @since 2022/9/1
 */
public class Main {

    public static void main(String[] args) {
        Person person = new Person();
        person.eat();
        person.echo();
    }
}