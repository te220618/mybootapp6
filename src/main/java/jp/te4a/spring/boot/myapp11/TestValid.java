package jp.te4a.spring.boot.myapp11;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TestValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestValid {

    String param();

    String message() default "入力値が不正です: {param}以外を入力してください";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
