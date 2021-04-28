package org.json;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ ElementType.METHOD })
public @interface JSONPropertyName {
    String value();
}
