package com.udemy.spring_basic.check;

import com.udemy.spring_basic.config.FilterConfig;
import com.udemy.spring_basic.scan.target.ExcludedRepository;
import com.udemy.spring_basic.scan.target.IncludedService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FilterScanDemo {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(FilterConfig.class);

        // 포함 대상 확인
        IncludedService included = ac.getBean(IncludedService.class);
        System.out.println("[FILTER] 포함 빈 존재 여부 = " + (included != null));
        System.out.println("[FILTER] 포함 빈 호출 = " + included.hello());

        // 제외 대상 확인
        try {
            ac.getBean(ExcludedRepository.class);
            System.out.println("[FILTER] ❌ 제외 대상이 빈으로 등록되어 버렸습니다 (문제)");
        } catch (Exception e) {
            System.out.println("[FILTER] ✅ 제외 대상은 빈이 아님 (정상)");
        }
    }
}
