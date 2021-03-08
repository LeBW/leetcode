import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1117. Building H2O
 * @author LBW
 */
public class BuildingH2O {
    private Semaphore hSmp;
    private Semaphore oSmp;

    private int hCount;
    public BuildingH2O() {
        hSmp = new Semaphore(2);
        oSmp = new Semaphore(0);
        hCount = 0;
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSmp.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        hCount += 1;
        if (hCount == 2) {
            oSmp.release();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSmp.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        hCount = 0;
        hSmp.release(2);
    }
}
