package ar.edu.unq.cryptop2p.audition;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
@AutoConfiguration
public class LogInfoAspectPointCut
{
    static Logger logger = LoggerFactory.getLogger(LogInfoAspectPointCut.class);

    @Pointcut("execution(* ar.edu.unq.cryptop2p.webservice.*.*(..))")
    public void entryPoint() throws Exception {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        throw new Exception("lalla");


    }


    @Around("entryPoint()")
    public void durationTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long end = System.currentTimeMillis();

        logger.info("Duration: " + (end - start));
    }


    @Before("entryPoint()")
    public void timeStamp() throws Throwable {
        logger.info("Timestamp: " + LocalDateTime.now());
    }

    @Before("entryPoint()")
    public void methodSignature(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Inside: " + joinPoint.getSignature());
    }

    @Before("entryPoint()")
    public void arguments(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("arguments: " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("entryPoint()")
    public void afterMethods() throws Throwable {
        logger.info("///////////////////// AFTER POINTCUT //////////////////////////");
    }

}
