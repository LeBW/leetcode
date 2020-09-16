/**
 * 贪心算法
 * @author LBW
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int min = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            else {
                res = Math.max(res, prices[i] - min);
            }
        }
        return res;
    }
}
