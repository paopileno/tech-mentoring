/*
 * Copyright (c) 2021 Nextiva, Inc. to Present.
 * All rights reserved.
 */

package com.frankmoley.lil.fid.aspect;

import java.util.Arrays;
import java.util.Collection;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("@annotation(Loggable)")
    public void executeLogging() {

    }

    @Before("executeLogging()")
    public void logMethodCall(JoinPoint joinPoint) {
        StringBuilder message = new StringBuilder("Method: ");
        message.append(joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();

        if (args != null && args.length > 0) {
           message.append(" args=[ | ");
            Arrays.stream(args).forEach(arg -> {
                message.append(arg).append(" | ");
            });
            message.append(" ]");
        }
        LOGGER.info(message.toString());
    }

    @AfterReturning(value = "executeLogging()", returning = "returnValue")
    public void logMethodCallAfterReturn(JoinPoint joinPoint, Object returnValue) {
        StringBuilder message = new StringBuilder("Method: ");
        message.append(joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();

        if (args != null && args.length > 0) {
            message.append(" args=[ | ");
            Arrays.stream(args).forEach(arg -> {
                message.append(arg).append(" | ");
            });
            message.append(" ]");
        }

        if (returnValue instanceof Collection) {
            message.append(", returning: ").append(((Collection)returnValue).size()).append(" instance(s).");
        } else {
            message.append(", returning: ").append(returnValue.toString());
        }
        LOGGER.info(message.toString());
    }

    @Around(value = "executeLogging()")
    public Object logMethodCallAround(ProceedingJoinPoint joinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        Object returnValue = joinPoint.proceed();
        long totalTime = System.currentTimeMillis() - startTime;
        StringBuilder message = new StringBuilder("Method: ");

        message.append(joinPoint.getSignature().getName());
        message.append(" totalTime: ").append(totalTime).append("ms");
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            message.append(" args=[ | ");
            Arrays.stream(args).forEach(arg -> {
                message.append(arg).append(" | ");
            });
            message.append(" ]");
        }

        if (returnValue instanceof Collection) {
            message.append(", returning: ").append(((Collection)returnValue).size()).append(" instance(s).");
        } else {
            message.append(", returning: ").append(returnValue.toString());
        }
        LOGGER.info(message.toString());

        return returnValue;
    }


}
