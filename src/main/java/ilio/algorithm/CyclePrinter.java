package ilio.algorithm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
        private final Semaphore curr;

        public Printer1(String val, Semaphore prev, Semaphore curr) {
            super(val);
            this.prev = prev;
            this.curr = curr;
        }

        @Override
        public void print() {
            prev.acquireUninterruptibly();
            System.out.print(getVal());
            curr.release();
        }
    }

    public static void main(String[] args) {
        Semaphore as = new Semaphore(0);
        Semaphore bs = new Semaphore(0);
        Semaphore cs = new Semaphore(1);
        Printer a = new Printer1("A", cs, as);
        Printer b = new Printer1("B", as, bs);
        Printer c = new Printer1("C", bs, cs);

        while (true) {
            new Thread(() -> a.print()).start();
            new Thread(() -> b.print()).start();
            new Thread(() -> c.print()).start();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
