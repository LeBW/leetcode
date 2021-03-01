/**
 * 303. Range Sum Query - Immutable
 * @author LBW
 */
public class RangeSumQuery {
    private int n;
    private int[] sum;

    public RangeSumQuery(int[] nums) {
        this.n = nums.length;
        if (n == 0)
            return;
        this.sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0)
            return sum[j];
        return sum[j] - sum[i - 1];
    }
}
