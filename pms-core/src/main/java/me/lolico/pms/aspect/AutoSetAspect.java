package me.lolico.pms.aspect;

import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.utils.SecurityUtils;
import me.lolico.pms.annotation.AutoSet;
import me.lolico.pms.enums.OperationType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @author lolico
 */
@Component
@Aspect
public class AutoSetAspect {

    public static final Logger log = LoggerFactory.getLogger(AutoSetAspect.class);

    @Pointcut("@annotation(me.lolico.pms.annotation.AutoSet)")
    public void pointcut() {
    }

    @Before("pointcut() && @annotation(autoSet)")
    public void before(JoinPoint joinPoint, AutoSet autoSet) {
        Object[] args = joinPoint.getArgs();
        String username = SecurityUtils.getUsername();
        if (args.length > 0) {
            Object target = args[0];
            if (target instanceof BaseEntity) {
                if (autoSet.value() == OperationType.UPDATE) {
                    ((BaseEntity) target).setUpdateBy(username);
                } else if (autoSet.value() == OperationType.INSERT) {
                    ((BaseEntity) target).setUpdateBy(username);
                    ((BaseEntity) target).setCreateBy(username);
                }
            } else {
                setProperty(target, autoSet.createByField(), username);
                setProperty(target, autoSet.updateByField(), username);
            }
        }
    }

    private void setProperty(Object target, String fieldName, String value) {
        try {
            Field field = target.getClass().getField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (NoSuchFieldException ignored) {
        } catch (IllegalAccessException e) {
            log.error("设置属性失败", e);
        }
    }
}
