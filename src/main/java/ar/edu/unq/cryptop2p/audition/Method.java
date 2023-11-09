package ar.edu.unq.cryptop2p.audition;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(2)
public class Method
{


    @Around("ar.edu.unq.cryptop2p.audition.PointCuts.entryPoint()")
    public void LogMethodSignatureAndArguments(ProceedingJoinPoint joinPoint) throws Throwable {
        methodSignature(joinPoint);
        arguments(joinPoint);
    }

    public void methodSignature(ProceedingJoinPoint joinPoint) throws Throwable {
        PointCuts.logger.info("Inside: " + joinPoint.getSignature());
        System.out.println("!!!metod1" + joinPoint.getSignature());
        System.out.println("!!!metod1");
    }


    void arguments(ProceedingJoinPoint joinPoint) throws Throwable {
        PointCuts.logger.info("arguments: " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("!!!metod2 " +Arrays.toString(joinPoint.getArgs()));
    }
}
