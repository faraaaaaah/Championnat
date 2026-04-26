package tn.esprit.ds.championnat.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class PerformanceAspect {
    @Around("execution(* tn.esprit.ds.championnat.services.*ServiceImpl.*(..))")
    public Object measurePerformance(ProceedingJoinPoint pjp) throws Throwable {

        String className  = pjp.getTarget().getClass().getSimpleName();
        String methodName = pjp.getSignature().getName();

        log.info("Before");
        log.info("Démarrage chronomètre pour : {}.{}()", className, methodName);
        long start = System.currentTimeMillis();

        Object result;
        try {
            result = pjp.proceed();
            long elapsed = System.currentTimeMillis() - start;
            log.info("{}.{}() terminé avec succès", className, methodName);
            if (result != null) {
                log.info("valeur retournée : {}", result);
            } else {
                log.info("valeur retournée : void / null");
            }
            log.info("Durée d'exécution : {} ms", elapsed);

            if (elapsed > 500) {
                log.warn("ATTENTION : méthode lente ({} ms > seuil 500 ms) !", elapsed);
            }
            return result;

        } catch (Throwable ex) {
            long elapsed = System.currentTimeMillis() - start;
            log.error("Exception dans {}.{}()", className, methodName);
            log.error("Type: {}", ex.getClass().getSimpleName());
            log.error("Message : {}", ex.getMessage());
            log.error("Durée avant exception : {} ms", elapsed);
            throw ex;
        }
    }
}
