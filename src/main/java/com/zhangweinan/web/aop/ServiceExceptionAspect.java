package com.zhangweinan.web.aop;

import com.zhangweinan.model.common.Result;
import com.zhangweinan.model.enums.WebsiteCodeEnum;
import com.zhangweinan.model.exception.WebsiteException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 业务异常切面
 * Created by Eric on 2019/4/13.
 */
@Aspect
@Component
public class ServiceExceptionAspect {

    @Pointcut("execution(* com.zhangweinan.service..*.*(..))")
    public void pointCut(){
    }


    @Around("pointCut()")
    public Result around(ProceedingJoinPoint joinPoint) throws Throwable {
        Result result = new Result();
        try {
            result = (Result) joinPoint.proceed();
        }catch (WebsiteException e){
            e.printStackTrace();
            result.fillErrorMessage(e.getResultCode(), e.getResultMsg());
        }catch (Exception e){
            e.printStackTrace();
            result.fillErrorMessage(WebsiteCodeEnum.SYSTEM_ERROR.getCode(), WebsiteCodeEnum.SYSTEM_ERROR.getDesc());
        }
        return result;
    }


}
