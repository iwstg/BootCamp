package com.udemy.spring_basic.grade;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GradeService {

    private final Map<String, Grade> grades;

    public GradeService(Map<String, Grade> grades) {
        this.grades = grades;
    }

    public String getGrade(GradeUser user, String gradeBeanName) {
        System.out.println("[DEBUG] grades map = " + grades);

        Grade strategy = grades.get(gradeBeanName);
        if (strategy == null) {
            throw new IllegalArgumentException(
                    "해당 이름의 Grade 빈을 찾을 수 없습니다: " + gradeBeanName +
                            " (가능한 값: " + grades.keySet() + ")"
            );
        }
        return strategy.userGrade(user);
    }

    public Map<String, Grade> getAllStrategies() {
        return grades;
    }
}
