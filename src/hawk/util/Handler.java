package hawk.util;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Handler {
}
