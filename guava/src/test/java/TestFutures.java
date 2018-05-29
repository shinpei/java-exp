import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestFutures {

    @Test
    void testBasic() throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(3);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hello");
            }
        };

        Future f = es.submit(task);
        System.out.println("HOH");
        f.get();
        System.out.println("Fin");

    }
}
