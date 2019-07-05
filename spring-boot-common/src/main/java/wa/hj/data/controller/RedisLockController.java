package wa.hj.data.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.redis.util.RedisLockRegistry;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * https://mp.weixin.qq.com/s/g7GFn4XKwvKycPRvViuzNg
 */
public class RedisLockController {
    @Autowired
    RedisLockRegistry redisLockRegistry;

    public void test() throws Exception {
        Lock lock = redisLockRegistry.obtain("lock");
        boolean b1 = lock.tryLock(3, TimeUnit.SECONDS);
        //log.info("b1 is : {}", b1);

        TimeUnit.SECONDS.sleep(5);

        boolean b2 = lock.tryLock(3, TimeUnit.SECONDS);
        //log.info("b2 is : {}", b2);

        lock.unlock();
        lock.unlock();
    }
}
