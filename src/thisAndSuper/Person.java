package thisAndSuper;

/**
 * @author xucheng.liu
 * @since 2022/3/10
 */
public class Person extends Creature {

    protected String name;

    private String phoneNo;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String parentName, String name) {
        super(parentName);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void getInfoList() {
        System.out.println(this.name);
        System.out.println(super.name);
    }
}
