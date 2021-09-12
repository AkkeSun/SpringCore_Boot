package com.example.boottest2.AOP;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Log4j2
public class LogAspect {

    // 해당 클래스 모든 매서드에 적용
    @Pointcut("execution(* com.example.boottest2.*.*(..))")
    public void point1(){};

    // 해당 빈 모든 매서드에 적용
    @Pointcut("bean(myService2)")
    public void point2(){};

    // 해당 어노테이션이 붙어있는 매서드에 적용
    @Pointcut("@annotation(MyAnnotation)")
    public void point3(){};

    // 타겟 메서드를 감싸서 실행
    @Around("point1()")
    public Object logAspect(ProceedingJoinPoint pjp) throws Throwable{

        //---------타겟 메서드 실행 전----------
        String param = Arrays.toString(pjp.getArgs());

        log.info("REQUEST <======= " + pjp.getSignature().getDeclaringTypeName() + "/"
                                     + pjp.getSignature().getName()  + " : " + param);

        //------------------------------------
        Object retVal = pjp.proceed();
        //------------------------------------

        //---------타겟 메서드 실행 후-----------
        log.info("RESPONSE =======> " + pjp.getSignature().getDeclaringTypeName() + "/"
                                      + pjp.getSignature().getName() + " : " + retVal);

        return retVal;
    }
}


