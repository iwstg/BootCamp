package com.udemy.spring_basic.scan.target;

import com.udemy.spring_basic.scan.anno.CustomExclude;

@CustomExclude
public class ExcludedRepository {
    public String hello() {
        return "Excluded";
    }
}
