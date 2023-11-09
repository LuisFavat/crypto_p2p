package ar.edu.unq.cryptop2p.audition;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
//@Order(0)
public class PointCuts
{
    static Logger logger = LoggerFactory.getLogger(PointCuts.class);

    @Pointcut("execution(* ar.edu.unq.cryptop2p.webservice.*.*(..))")
    public void entryPoint() throws Exception {
        System.out.println("!!!!!!!!!!!!!!!!!!");
    }

}