package ilio.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author hyia
 * @Date 2020/09/22 18:17
 */
public class Messager {

    public static class Executor {
        private static final Semaphore semaphore = new Semaphore(0);

        private final List<Object> pool;

        public Executor(List<Object> pool) {
            this.pool = pool;
        }

        public Object consume() {
            while (true) {
                if (pool.isEmpty()) {
                    semaphore.acquireUninterruptibly();
                }
                synchronized (pool) {
                    if (!pool.isEmpty()) {
                        return pool.remove(0);
                    }
                }
            }
        }

        public void produce(Object obj) {
            synchronized (pool) {
                pool.add(obj);
            }
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        List<Object> pool = new ArrayList<>();
        Executor consumer1 = new Executor(pool);
        Executor consumer2 = new Executor(pool);
        Executor consumer3 = new Executor(pool);

        Executor producer1 = new Executor(pool);
        Executor producer2 = new Executor(pool);

        AtomicInteger ai = new AtomicInteger();
        ExecutorService producerExecutor = Executors.newFixedThreadPool(5);
        ExecutorService consumerExecutor = Executors.newFixedThreadPool(5);

        int i = 0;
        while(true) {
            i++;
        }
//        while(true) {
//            producerExecutor.execute(() -> {
//                producer1.produce(ai.incrementAndGet());
//            });
//            producerExecutor.execute(() -> {
//                producer2.produce(ai.incrementAndGet());
//            });
//            consumerExecutor.execute(() -> {
//                System.out.println(consumer1.consume());
//            });
//            consumerExecutor.execute(() -> {
//                System.out.println(consumer2.consume());
//            });
//            consumerExecutor.execute(() -> {
//                System.out.println(consumer3.consume());
//            });
//        }
    }

}
