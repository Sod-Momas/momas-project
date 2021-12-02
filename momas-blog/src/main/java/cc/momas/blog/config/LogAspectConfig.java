package cc.momas.blog.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Arrays;

/**
 * 日志切面
 *
 * @author 陈伟明
 * @since 2021/11/29
 */
@Aspect
@Configuration
@EnableAspectJAutoProxy
public class LogAspectConfig {
    private static final Logger log = LoggerFactory.getLogger(LogAspectConfig.class);

//    @Pointcut("execution(* cc.momas.blog.service.*.*(..))")
//    public void logAspect() {
//    }

    /**
     * 环绕通知：目标方法执行前后分别执行一些代码，发生异常的时候执行另外一些代码
     */
    @Around(value = "execution(* cc.momas.blog..*.*(..))")
    public Object aroundMethod(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        Signature signature = jp.getSignature();
        String method = signature.getName();
        String clazz = jp.getTarget().getClass().getSimpleName();
        long start = System.currentTimeMillis();

        Object result = jp.proceed();
        if (log.isInfoEnabled()) {
            String logLine = "{ \"duration\": \"{}ms\", \"method\": \"{}.{}\", \"param\": \"{}\", \"return\": \"{}\" }";
            log.info(logLine, System.currentTimeMillis() - start, clazz, method, Arrays.toString(args), result);
        }
        return result;
    }

}
