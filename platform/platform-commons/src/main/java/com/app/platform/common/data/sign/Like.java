package com.app.platform.common.data.sign;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Like {
    String LEFT = "left";
    String RIGHT = "right";
    String AROUND = "around";

    String location() default AROUND;
}
