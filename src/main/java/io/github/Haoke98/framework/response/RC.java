package io.github.Haoke98.framework.response;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 服务状态码注解类
 * 主要是为了方便记录状态码对应的message信息。
 * @author 萨达木(sadam)
 * @date 2021/10/22 16:44
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RC {
    String msg();
}
