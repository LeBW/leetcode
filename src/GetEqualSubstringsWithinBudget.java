/**
 * 1208. Get Equal Substrings Within Budget
 * @author LBW
 */
public class GetEqualSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        // 滑动窗口
        int i = 0, j = 0, cost = 0, res = 0;
        while (j < n) {
            if (cost + distance[j] <= maxCost) {
                cost += distance[j];
                res = Math.max(res, j - i + 1);
                j++;
            }
            else {
                cost -= distance[i++];
            }
        }
        return res;
    }
}
