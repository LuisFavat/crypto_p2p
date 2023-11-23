package ar.edu.unq.cryptop2p.audition;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
@Order(0)
public class Auditioner {

    Logger logger = LoggerFactory.getLogger(Auditioner.class);

    @Pointcut("execution(* ar.edu.unq.cryptop2p.webservice.*.*(..))")
    public void entryPoint() throws Exception {
    }

    @Around("entryPoint()")
    public Object durationTime(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Timestamp: " + LocalDateTime.now());

        long start = System.currentTimeMillis();

        methodSignature(joinPoint);
        arguments(joinPoint);

        Object proceed = joinPoint.proceed();

        long end = System.currentTimeMillis();

        logger.info("Duration: " + (end - start));

        return proceed;
    }

    public void methodSignature(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("method signature: " + joinPoint.getSignature());
    }


    void arguments(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("arguments: " + Arrays.toString(joinPoint.getArgs()));
    }
}
