package com.memo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect // 부가 기능 정의(advice) + 어디에 적용(pointcut)
@Component
public class TimeTraceAop {

    //@Around("execution(* com.memo..*(..))") // 패키지 범위, pointcut(어디에)
    @Around("@annotation(TimeTrace)") // 어느 어노테이션이 붙어있을 때 사용?
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        // 시간 측정
        StopWatch sw = new StopWatch();
        sw.start();

        // 원래 할 일
        Object proceedObj = joinPoint.proceed(); // 기능 수행

        // 끝
        sw.stop();
        log.info("##### 실행 시간(ms): {}", sw.getTotalTimeMillis());
        log.info("$$$$ {}", sw.prettyPrint());

        return proceedObj;
    }
}
