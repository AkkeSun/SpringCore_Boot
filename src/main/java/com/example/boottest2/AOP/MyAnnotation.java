package com.example.boottest2.AOP;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface
MyAnnotation {
}
