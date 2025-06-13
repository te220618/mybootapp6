package jp.te4a.spring.boot.myapp13;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class WritterValidator implements ConstraintValidator<Writter, String> {

    private String okValue;

    @Override
    public void initialize(Writter constraintAnnotation) {
        this.okValue = constraintAnnotation.ok();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;  // nullはNGにする場合
        }
        return value.equals(okValue);  // okに指定した値と一致すればOK
    }
}
