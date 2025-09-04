package com.udemy.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long  userIdx;
    private String userId;
    private String userName;
    private String rank;
    private LocalDate registrationDate;
    private LocalDate updateDate;
}
