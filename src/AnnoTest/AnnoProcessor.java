package AnnoTest;

import java.lang.reflect.Field;

/**
 * User: lxcfour
 * Date: 2018/3/14
 * Time: 下午3:59
 */
public class AnnoProcessor {

    public static void getInfo(Class<?> clazz) {
        String name = "";
        String gender = "";
        String profile = "";

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Name.class)) {
                Name nameAnno = field.getAnnotation(Name.class);
                name = name + nameAnno.value();
            }
            if (field.isAnnotationPresent(Gender.class)) {
                Gender arg0 = field.getAnnotation(Gender.class);
                gender = gender + arg0.value().toString();
            }
            if (field.isAnnotationPresent(Profile.class)) {
                Profile arg0 = field.getAnnotation(Profile.class);
                profile = "[id=" + arg0.id() + ",height=" + arg0.height() + ",nativePlace=" + arg0.nativePlace() + "]";
            }
        }
    }
}
