package com.udemy.spring_basic.grade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GradeUser {
    private final Long id;
    private final String name;
    private final String rank;

    @Override
    public String toString() {
        return "Grade User = "
                + id +
                ", name='" + name + '\'' +
                ", rank='" + rank + '\'';
    }
}
