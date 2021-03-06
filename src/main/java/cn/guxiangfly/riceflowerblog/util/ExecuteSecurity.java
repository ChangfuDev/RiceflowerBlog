package cn.guxiangfly.riceflowerblog.util;

import java.lang.annotation.*;

/**
 * 忽略安全性检查
 *
 * @author panhainan
 * @since 1.0.0
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExecuteSecurity {
}
