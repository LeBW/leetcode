/**
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 * @author LBW
 */
public class BestTimeToBASStockWTF {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n < 2)
            return 0;
        //int[][] dp = new int[n][2];
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < n; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}
