package AnnoTest;

import java.lang.annotation.*;

/**
 * User: lxcfour
 * Date: 2018/3/14
 * Time: 下午4:18
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Required {
    boolean value() default true;
}
