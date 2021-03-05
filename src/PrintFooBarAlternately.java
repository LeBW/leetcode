/**
 * 1115. Print FooBar Alternately
 * 记住要用 Thread.yield 主动让出 CPU
 * @author LBW
 */
public class PrintFooBarAlternately {
    private int n;
    private volatile int v;

    public PrintFooBarAlternately(int n) {
        this.n = n;
        v = 0;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (v != 0) {
                Thread.yield();
            }
            printFoo.run();
            v = 1;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (v != 1) {
                Thread.yield();
            }
            printBar.run();
            v = 0;
        }
    }
}
