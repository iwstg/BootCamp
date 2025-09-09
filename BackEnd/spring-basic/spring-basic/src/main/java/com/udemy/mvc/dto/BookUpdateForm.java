package com.udemy.mvc.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookUpdateForm {

    // hidden input 으로 id값을 던져줌.
    private Long id;

    @NotBlank(message = "책 제목은 필수 입력값입니다.")
    private String Title;

    @NotBlank(message = "출판사는 필수 입력값입니다.")
    private String Publisher;
}
