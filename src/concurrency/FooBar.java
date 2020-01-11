package concurrency;

import java.util.concurrent.*;

public class FooBar {

    private int n;
    Semaphore s, s2;

    public FooBar(int n) {
        this.n = n;
        s = new Semaphore(0);
        s2 = new Semaphore(1);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            s2.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            s.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            s.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            s2.release();
        }
    }
}
