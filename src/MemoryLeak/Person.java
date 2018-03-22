package MemoryLeak;

import java.io.Serializable;

/**
 * Created by liuxucheng on 2018/2/25.
 */
public class Person implements Serializable {

    private String name;

    private String userName;

    private int age;

    public Person (String name, String userName, int age) {
        this.name = name;
        this.userName = userName;
        this.age = age;
    }

    public Person() {

    }

    @Override
    public int hashCode() {
        int res = 31;
        return res + age;
    }

    @Override
    public String toString() {
        return "name: " + name + ", userName: " + userName + ", age: " + age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
