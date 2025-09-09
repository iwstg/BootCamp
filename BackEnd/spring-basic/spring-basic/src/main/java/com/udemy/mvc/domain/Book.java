package com.udemy.mvc.domain;
import com.udemy.mvc.validate.BookCreate;
import com.udemy.mvc.validate.BookUpdate;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @NotNull(groups = {BookUpdate.class})
    private Long id;

    @NotBlank(groups = {BookCreate.class}, message = "책 제목은 필수 입력값입니다.")
    @NotNull
    private String title;

    @NotBlank(groups = {BookCreate.class}, message = "출판사는 필수 입력값입니다.")
    @NotNull
    private String publisher;

    @NotNull(groups = {BookCreate.class, BookUpdate.class})
    @Min(value = 0, message = "판매 가격은 0 이상이어야 합니다.")
    private double salePrice;

    @Min(value = 0, message = "대여 가격은 0 이상이어야 합니다.")
    private double rentalPrice;

    private String renter;
    private LocalDate registrationDate;
    private LocalDate updateDate;
}
