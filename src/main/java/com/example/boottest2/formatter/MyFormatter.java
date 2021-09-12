package com.example.boottest2.formatter;

import com.example.boottest2.MyDto;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class MyFormatter implements Formatter<MyDto> {
    @Override
    public MyDto parse(String text, Locale locale) throws ParseException {
        MyDto dto = new MyDto();
        dto.setPwd(text);
        return dto;
    }

    @Override
    public String print(MyDto object, Locale locale) {
        return null;
    }
}
