package InheritTest;

/**
 * @author xucheng.liu
 * @date 2020/3/27
 */
public class Country {

    private String name;

    public Country() {

    }

    public Country(String name) {
        this.name = name;
    }

    public void value() {
        this.name = "China";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
