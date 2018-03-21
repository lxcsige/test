package AnnoTest;

import java.lang.annotation.*;

/**
 * User: lxcfour
 * Date: 2018/3/14
 * Time: 下午3:58
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Profile {
    int id() default -1;

    int height() default 0;

    String nativePlace() default "";
}
