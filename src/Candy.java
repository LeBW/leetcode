/**
 * 135. Candy
 * 贪心算法。
 * 两次遍历，分别满足左规则和右规则，然后取其中较大即可。
 * 参考题解 https://leetcode-cn.com/problems/candy/solution/candy-cong-zuo-zhi-you-cong-you-zhi-zuo-qu-zui-da-/
 * @author LBW
 */
public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 0; i < n - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                left[i + 1] = left[i] + 1;
            }
            else {
                left[i + 1] = 1;
            }
        }
        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1]) {
                right[i - 1] = right[i] + 1;
            }
            else {
                right[i - 1] = 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }
}
