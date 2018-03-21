package AnnotationTest;

import java.lang.annotation.*;

/**
 * Created by lxcfour on 16/8/3.
 */
@Documented
@Inherited
@Target(ElementType.TYPE) // 应用于类、接口、enum、注解类型
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTables {
    String name() default "";
}
