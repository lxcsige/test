package AnnoTest;

import java.lang.annotation.*;

/**
 * User: lxcfour
 * Date: 2018/3/14
 * Time: 下午3:54
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Gender {
    GenderEnum value() default GenderEnum.MALE;
}
