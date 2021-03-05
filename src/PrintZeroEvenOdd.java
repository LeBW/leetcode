import java.util.function.IntConsumer;

/**
 * 1116. Print Zero Even Odd
 * @author LBW
 */
public class PrintZeroEvenOdd {
    private int n;
    private boolean isOdd;
    private volatile int even;
    private volatile int odd;

    public PrintZeroEvenOdd(int n) {
        this.n = n;
        isOdd = true;
        odd = 0;
        even = 0;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (odd == 1 || even == 1) {
                Thread.yield();
            }
            printNumber.accept(0);
            if (isOdd) {
                odd = 1;
            }
            else {
                even = 1;
            }
            isOdd = !isOdd;
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            while (even == 0) {
                Thread.yield();
            }
            printNumber.accept(i);
            even = 0;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (odd == 0) {
                Thread.yield();
            }
            printNumber.accept(i);
            odd = 0;
        }
    }
}
