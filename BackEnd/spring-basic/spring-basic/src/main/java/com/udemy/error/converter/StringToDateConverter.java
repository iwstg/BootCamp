package com.udemy.error.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class StringToDateConverter implements Converter<String, Date> {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date convert(String s) {
        try{
            return dateFormat.parse(s);
        }catch (ParseException e){
            throw new IllegalArgumentException("잘못된 날짜 형식입니다. (yyyy-mm-dd)");
        }
    }

}
