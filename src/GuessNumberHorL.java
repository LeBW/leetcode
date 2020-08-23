/**
 * 374. Guess Number Higher or Lower
 * 二分查找
 * @author LBW
 */
public class GuessNumberHorL {
    public int guessNumber(int n) {
        return guessNumber(1, n);
    }

    private int guessNumber(int start, int end) {
        int mid = start + (end - start) / 2;
        int res = guess(mid);
        if (res == 0)
            return mid;
        else if (res == -1) {
            return guessNumber(start, mid - 1);
        }
        else {
            return guessNumber(mid + 1, end);
        }
    }

    // 为了编译通过写个guess
    private int guess(int guess) {
        return 0;
    }
}
