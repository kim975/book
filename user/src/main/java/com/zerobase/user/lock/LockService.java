package com.zerobase.user.lock;

import com.zerobase.user.exception.BaseException;
import com.zerobase.user.exception.BasicErrorCode;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LockService {

    private final RedissonClient redisson;

    public void pointLock(Long userId) {
        RLock lock = redisson.getLock(getLockKey(userId));

        boolean isLock = false;
        try {
            isLock = lock.tryLock(20, 10, TimeUnit.SECONDS);
            if (!isLock) {
                throw new BaseException(BasicErrorCode.COMMON_POINT_ERROR);
            }
        } catch (InterruptedException e) {
            throw new BaseException(BasicErrorCode.COMMON_POINT_ERROR);
        }
    }

    public void pointUnlock(Long userId) {
        redisson.getLock(getLockKey(userId)).unlock();
    }

    private static String getLockKey(Long userId) {
        return "POINT_LOCK: " + userId;
    }

}
