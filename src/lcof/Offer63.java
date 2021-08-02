package lcof;

/**
 * Offer 63. 股票的最大利润
 * 遍历一次，记录当前最低点即可。
 * @author LBW
 */
public class Offer63 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int res = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min > res) {
                res = prices[i] - min;
            }
            min = Math.min(min, prices[i]);
        }
        return res;
    }
}
