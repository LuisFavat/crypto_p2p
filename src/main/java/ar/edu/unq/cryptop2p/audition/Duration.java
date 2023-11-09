package ar.edu.unq.cryptop2p.audition;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
//@Order(3)
public class Duration {

    @Around("ar.edu.unq.cryptop2p.audition.PointCuts.entryPoint()")
    public void durationTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long end = System.currentTimeMillis();

        PointCuts.logger.info("Duration: " + (end - start));
        System.out.println("end ----- around");
    }
}
