package com.zerobase.user.aop;

import com.zerobase.user.lock.LockService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class LockAopAspect {

    private final LockService lockService;

    @Around("@annotation(com.zerobase.user.aop.PointLock) && args(command,..)")
    public Object aroundMethod(
        ProceedingJoinPoint pjp,
        PointLockInterface command
    ) throws Throwable {

        // lock 취득 시도
        lockService.pointLock(command.getUserId());

        try {
            return pjp.proceed();
        } finally {
            // lock 해제
            lockService.pointUnlock(command.getUserId());
        }

    }


}
