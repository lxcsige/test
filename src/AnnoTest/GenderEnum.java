package AnnoTest;

/**
 * User: lxcfour
 * Date: 2018/3/14
 * Time: 下午3:55
 */
public enum GenderEnum {
    MALE(1, "男"),
    FEMALE(2, "女"),
    OTHER(3, "未知"),
    ;

    private int key;

    private String desc;

    GenderEnum(int key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
