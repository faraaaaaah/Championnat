package tn.esprit.ds.championnat.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @Before("execution(* tn.esprit.ds.championnat.services.*ServiceImpl.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String className  = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        log.info("méthode" + className + "." + methodName + "s'éxecute");
    }
    @After("execution(* tn.esprit.ds.championnat.services.*ServiceImpl.*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        String className  = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        log.info("méthode" + className + "." + methodName + "terminée");
    }
    @AfterReturning(pointcut = "execution(* tn.esprit.ds.championnat.services.*ServiceImpl.*(..))", returning = "result")
    public void logMethodReturn(JoinPoint joinPoint, Object result) {
        String className  = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        log.info("méthode" + className + "." + methodName + "exécutée");
        log.info("valeur retournée : {}", result);
    }
    @AfterThrowing(pointcut = "execution(* tn.esprit.ds.championnat.services.*ServiceImpl.*(..))", throwing = "exception")
    public void logMethodException(JoinPoint joinPoint, Throwable exception) {
        String className  = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        log.error("méthode" + className + "." + methodName);
        log.error("message:" , exception.getMessage());
    }
}
