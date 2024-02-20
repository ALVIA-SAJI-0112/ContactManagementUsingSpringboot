package com.example.ContactManagement.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Define pointcut expression for UserController methods
    @Pointcut("execution(* com.example.ContactManagement.Controller.UserController.*(..))")
    public void userControllerMethods() {}

    // Define pointcut expression for UserServiceImpl methods
    @Pointcut("execution(* com.example.ContactManagement.Services.UserServiceImpl.*(..))")
    public void userServiceImplMethods() {}

    // Advice to log method executions before execution
    @Before("userControllerMethods() || userServiceImplMethods()")
    public void logBeforeMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Executing method: " + methodName);
    }

    // Advice to log method executions after returning successfully
    @AfterReturning(pointcut = "userControllerMethods() || userServiceImplMethods()", returning = "result")
    public void logAfterReturningMethodExecution(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Method executed successfully: " + methodName + ", Result: " + result);
    }
}