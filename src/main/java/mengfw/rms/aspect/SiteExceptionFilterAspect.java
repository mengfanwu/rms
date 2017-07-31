package mengfw.rms.aspect;

import mengfw.rms.helper.ServletHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by MFW on 2017/5/29.
 */
//@Aspect
//@Order(2)
//@Configuration
public class SiteExceptionFilterAspect {
    private static  final Logger LOGGER = LoggerFactory.getLogger(SiteExceptionFilterAspect.class);
    @Pointcut("execution(* com.mengfw.controller..*.*(..))")
    public void executeService(){

    }

    @Around("executeService()")
    public Object filter(ProceedingJoinPoint joinPoint){
        try {
            return joinPoint.proceed();
        }catch (Exception var2) {
            LOGGER.error(var2.getMessage(), var2);
            ServletHelper.sendResponse(500, var2.getMessage());
        } catch (Throwable var6) {
            LOGGER.error(var6.getMessage(), var6);
            ServletHelper.sendResponse(500, "未知错误.");
        }

        return null;
    }
}
