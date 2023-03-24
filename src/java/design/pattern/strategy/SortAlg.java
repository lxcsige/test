package design.pattern.strategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 排序策略注解
 *
 * @author liuxucheng
 * @since 2023/1/9
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SortAlg {

    /**
     * 策略名称
     *
     * @return
     */
    String value() default "";
}
