import com.google.common.util.concurrent.RateLimiter;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestRateLimiter {

    private void process(int qps) throws InterruptedException {
        Random rnd = new Random();
        Thread.sleep(rnd.nextInt(1000/qps));
    }

    @Test
    public void testRateLimit() throws InterruptedException {
        int QPS = 5;
        RateLimiter rlimit = RateLimiter.create(QPS);
        while(true) {
            if (rlimit.tryAcquire(20, TimeUnit.MILLISECONDS )) {
                System.out.println("Success");
            } else {
                System.out.println("Fail");
            }
            process(QPS);
        }
    }
}
