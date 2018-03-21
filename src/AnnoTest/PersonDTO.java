package AnnoTest;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * User: lxcfour
 * Date: 2018/3/14
 * Time: 下午4:20
 */
public class PersonDTO implements Serializable {

    private int id;

    @Required
    private String name;

    private int age;

    private int height;

    private int weight;

    private String address;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean validate() throws Exception {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            // 存在注解 && 注解参数value = true
            if (field.isAnnotationPresent(Required.class) && field.getAnnotation(Required.class).value()) {
                String type = field.getGenericType().toString();
                if ("class java.lang.String".equals(type)) {
                    Method method = this.getClass().getMethod(getMethodName(field.getName()));
                    String value = (String) method.invoke(this);
                    if (value == null || value.length() == 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    /**
     * 拼接成员变量的getter方法
     * @param name
     * @return
     */
    private String getMethodName(String name) {
        String upperName = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
        return "get" + upperName;
    }

    public static void main(String[] args) {
        PersonDTO person = new PersonDTO();
        boolean result;
        try {
            result = person.validate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
