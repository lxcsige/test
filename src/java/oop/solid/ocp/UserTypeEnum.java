package oop.solid.ocp;

/**
 * @author liuxucheng
 * @since 2022/11/22
 */
public enum UserTypeEnum {

    ORDINARY(1, "普通用户"),
    SLUM_DOG_VIP(2, "穷狗VIP"),
    REAL_VIP(2, "VIP"),
    SUPER_VIP(3, "超级VIP"),
    ;

    private int type;

    private String name;

    UserTypeEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
