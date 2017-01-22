package com.shawn.monitor;

import com.shawn.web.exception.ServerInternalErrorException;
import lombok.extern.apachecommons.CommonsLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Xiaoyue Xiao
 */
@CommonsLog
@Aspect
@Component
public class ServiceMonitor {

    /**
     * A join point is in the service layer if the method is defined
     * in a type in the com.shawn.service package or any sub-package
     * under that.
     */
    @Pointcut("execution(* com.shawn.service..*(..))")
    private void serviceLayer() {
    }

    /**
     * Monitor whether exception is thrown in service layer. If exception
     * has been thrown, in order to detecting it conveniently, log the
     * situation where it happened. Then create a server internal error
     * exception and throw it out.
     */
    @AfterThrowing(pointcut = "com.shawn.monitor.ServiceMonitor.serviceLayer()", throwing = "e")
    public void monitorException(JoinPoint joinPoint, Throwable e) {
        // Log the situation where exception happened
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        log.error("[" + signature.toShortString() + "]" + Arrays.toString(args) + "[" + e.toString() + "]");

        // Throw a new server internal error exception
        throw new ServerInternalErrorException();
    }

}
