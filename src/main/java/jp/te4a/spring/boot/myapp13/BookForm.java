package jp.te4a.spring.boot.myapp13;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookForm {

    private Integer id;

    @NotNull(message = "タイトルは必須です")
    @Size(min = 3, message = "タイトルは3文字以上で入力してください")
    @TestValid(param = "abc")  
    private String title;

    @Writter(ok = "東北タロウ")
    private String writter;

    private String publisher;

    @Min(value = 0, message = "価格は0以上で入力してください")
    private Integer price;
}
