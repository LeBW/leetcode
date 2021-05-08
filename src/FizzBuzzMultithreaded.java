import java.util.function.IntConsumer;

/**
 * 1195. Fizz Buzz Multithreaded.
 * 交替打印字符串。
 * 运用锁，全局变量i 从 1 到 n
 * @author LBW
 */
public class FizzBuzzMultithreaded {
    private int n;
    private int i = 1;

    public FizzBuzzMultithreaded(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (i <= n) {
            synchronized (this) {
                if (i <= n && i % 3 == 0 && i % 5 != 0) {
                    printFizz.run();
                    i += 1;
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (i <= n) {
            synchronized (this) {
                if (i <= n && i % 3 != 0 && i % 5 == 0) {
                    printBuzz.run();
                    i += 1;
                }
            }
        }

    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (i <= n) {
            synchronized (this) {
                if (i <= n && i % 3 == 0 && i % 5 == 0) {
                    printFizzBuzz.run();
                    i += 1;
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            synchronized (this) {
                if (i <= n && i % 3 != 0 && i % 5 != 0) {
                    printNumber.accept(i);
                    i += 1;
                }
            }
        }
    }
}
