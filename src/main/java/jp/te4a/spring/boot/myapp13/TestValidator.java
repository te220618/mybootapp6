package jp.te4a.spring.boot.myapp13;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TestValidator implements ConstraintValidator<TestValid, String> {

    private String param;

    @Override
    public void initialize(TestValid constraintAnnotation) {
        this.param = constraintAnnotation.param();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;  // nullはNG
        }
        return !value.equals(param);  // paramと一致したらNG
    }
}
