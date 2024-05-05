import java.util.Random;

/**
 * Implement Rand10() Using Rand7()
 * 拒绝采样，也就是达不到效果就再来一次
 * 由于 7 比 10 小，所以要采样两次，取值 1 - 49，然后如果落在1-40内就返回，否则重新采样
 * @author LBW
 */
public class Rand7Rand10 {
    public int rand10() {
        int row, col, val;
        do {
            row = rand7();
            col = rand7();
            val = (row - 1) * 7 + col;
        } while (val > 40);
        // val is between [1, 40]
        return val % 10 + 1;
    }

    private int rand7() {
        return new Random().nextInt(7) + 1;
    }
}
