package com.example.boottest2;

import com.example.boottest2.AOP.MyAnnotation;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MyService3 {

    @MyAnnotation
    public void myMethod(){
        log.info("In myMethod");
    }

}
