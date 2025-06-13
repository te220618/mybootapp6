package jp.te4a.spring.boot.myapp11;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = WritterValidator.class)  // バリデータを指定
@Target({ ElementType.FIELD, ElementType.METHOD })  // フィールドやメソッドに付ける
@Retention(RetentionPolicy.RUNTIME)
public @interface Writter {

    String ok();  // 許可する値をセット

    String message() default "Input 入力値";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
