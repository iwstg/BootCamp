package com.udemy.mvc.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookCreateForm {

    @NotBlank(message = "책 제목은 필수 입력값입니다.")
    private String Title;

    @NotBlank(message = "출판사는 필수 입력값입니다.")
    private String Publisher;

    @NotNull(message = "판매 가격은 필수 입력값입니다.")
    @Min(value = 0, message = "판매 가격은 0 이상이어야 합니다.")
    private double salePrice;
}
