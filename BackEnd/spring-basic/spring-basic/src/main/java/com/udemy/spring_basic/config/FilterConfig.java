package com.udemy.spring_basic.config;

import com.udemy.spring_basic.scan.anno.CustomExclude;
import com.udemy.spring_basic.scan.anno.CustomInclude;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "com.udemy.spring_basic.scan.target",
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = CustomInclude.class),
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = CustomExclude.class)
)
public class FilterConfig {

}
