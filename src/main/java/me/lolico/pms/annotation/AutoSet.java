package me.lolico.pms.annotation;

import me.lolico.pms.enums.OperationType;

import java.lang.annotation.*;

/**
 * @author lolico
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoSet {
    OperationType value();

    String updateByField() default "updateBy";

    String createByField() default "createBy";
}
