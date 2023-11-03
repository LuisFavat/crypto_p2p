package ar.edu.unq.cryptop2p.audition;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.springframework.web.bind.annotation.RestController;

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

    @Before("entryPoint()")
    public void beforeMethods() throws Throwable {
        logger.info("/////////////// BEFORE POINTCUT //////////////////////////////");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    @After("entryPoint()")
    public void afterMethods() throws Throwable {
        logger.info("///////////////////// AFTER POINTCUT //////////////////////////");
    }

}
