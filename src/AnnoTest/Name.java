package AnnoTest;

import java.lang.annotation.*;

/**
 * User: lxcfour
 * Date: 2018/3/14
 * Time: 下午3:51
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Name {
    String value() default "";
}
