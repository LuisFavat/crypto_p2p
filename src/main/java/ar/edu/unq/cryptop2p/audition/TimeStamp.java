package ar.edu.unq.cryptop2p.audition;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//@Aspect
//@Component
//@Order(1)
public class TimeStamp {

    @Before("ar.edu.unq.cryptop2p.audition.PointCuts.entryPoint()")
    public void timeStamp() throws Throwable
    {
        PointCuts.logger.info("Timestamp: " + LocalDateTime.now());
        System.out.println("!!!before");
    }
}
