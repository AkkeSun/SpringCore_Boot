package com.example.boottest2;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MyService {
    public void myMethod(){
        log.info("In myMethod");
    }
}
