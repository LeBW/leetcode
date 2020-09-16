/**
 * 1105. Filling Bookcase Shelves
 * dp[i]表示摆放前i本书时的最小高度。
 * 最后一层依次尝试最后1本，2本，...，直到最后一层宽度放满，在其中找总体的最小高度。
 * 状态转移方程：dp[i] = min(dp[j-1] + maxheight[j~i])
 * @author LBW
 */
public class FillingBookcaseShelves {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int n = books.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = books[0][1];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + books[i-1][1];
            int j = i, curWidth = 0, curHeight = 0;
            while (j > 0) {
                curWidth += books[j-1][0];
                curHeight = Math.max(curHeight, books[j-1][1]);
                if (curWidth > shelf_width)
                    break;
                dp[i] = Math.min(dp[i], dp[j-1] + curHeight);
                j -= 1;
            }
        }
        return dp[n];
    }
}
