package ilio.algorithm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author hyia
 * @Date 2020/09/23 12:29
 */
public class CyclePrinter {

    public static abstract class Printer {
        private final String val;

        public Printer(String val) {
            this.val = val;
        }

        public abstract void print();

        protected final String getVal() {
            return this.val;
        }
    }

    public static class Printer1 extends Printer {
        private final Semaphore prev;
        private final Semaphore next;

        public Printer1(String val, Semaphore prev, Semaphore next) {
            super(val);
            this.prev = prev;
            this.next = next;
        }

        @Override
        public void print() {
            prev.acquireUninterruptibly();
            System.out.print(getVal());
            next.release();
        }
    }

    public static class Printer2 extends Printer {
        private final String next;
        private final AtomicReference<String> atomic;
        public Printer2(String val, String next, AtomicReference<String> atomic) {
            super(val);
            this.next = next;
            this.atomic = atomic;
        }

        @Override
        public void print() {
            while (true) {
                synchronized (atomic) {
                    if (atomic.compareAndSet(getVal(), next)) {
                        System.out.print(getVal());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        AtomicReference<String> atomic = new AtomicReference<>("A");
        Printer a = new Printer2("A", "B", atomic);
        Printer b = new Printer2("B", "C", atomic);
        Printer c = new Printer2("C", "A", atomic);
        ExecutorService executor = Executors.newFixedThreadPool(5);

        while (true) {
            executor.execute(() -> a.print());
            executor.execute(() -> b.print());
            executor.execute(() -> c.print());
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
