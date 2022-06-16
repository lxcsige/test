package InitializationTest;

import java.io.Serializable;

/**
 * @author xucheng.liu
 * @date 2020/6/4
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 5270195877010628671L;

    public static String nationality = "CHINA";

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
