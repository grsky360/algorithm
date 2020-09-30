package ilio.algorithm.other;

import java.util.concurrent.Semaphore;

/**
 * @Author hyia
 * @Date 2020/09/30 19:32
 * @url https://leetcode-cn.com/problems/print-foobar-alternately/
 */
public class FooBar {
    private final Semaphore foo = new Semaphore(1);
    private final Semaphore bar = new Semaphore(0);
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            bar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.release();
        }
    }

    public static void main(String[] args) {

    }
}
