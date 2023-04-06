package com.marco.springcloud.msvc.users.msvcusers.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Aspect
@Component
@Slf4j
public class MeasureTimeAdvice {
    @Around("@annotation(MeasureTime)")
    public Object measureTime( ProceedingJoinPoint point) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object object = point.proceed();
        stopWatch.stop();
        log.info("Time taken by " + point.getSignature().getName() + "() method is "
                 + stopWatch.getTotalTimeMillis() + " ms");
        return object;
    }
}
