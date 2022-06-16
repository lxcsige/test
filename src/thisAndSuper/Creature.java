package thisAndSuper;

/**
 * @author xucheng.liu
 * @since 2022/3/10
 */
public class Creature {

    private int id;

    private int age;

    protected String name;

    public Creature() {

    }

    public Creature(int id) {
        this.id = id;
    }

    public Creature(int id, String name) {
        this(id);
        this.name = name;
    }

    public Creature(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
