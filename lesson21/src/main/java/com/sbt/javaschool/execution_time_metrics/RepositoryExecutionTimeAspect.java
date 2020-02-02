package com.sbt.javaschool.execution_time_metrics;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class RepositoryExecutionTimeAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryExecutionTimeAspect.class);

    @Around("within(@org.springframework.stereotype.Repository *))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            return joinPoint.proceed();
        } finally {
            stopWatch.stop();
            LOGGER.info("Execution of method " + joinPoint.getSignature().toString() + " took: " + stopWatch.getTotalTimeMillis() + " ms");
        }
    }
}
