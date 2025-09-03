package com.udemy.spring_basic.scan.target;

import com.udemy.spring_basic.scan.anno.CustomInclude;

@CustomInclude
public class IncludedService {
    public String hello() {
        return "Included";
    }

}
