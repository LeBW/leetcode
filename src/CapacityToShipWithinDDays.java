/**
 * 1011. Capacity To Ship Within D Days.
 * 二分法
 * @author LBW
 */
public class CapacityToShipWithinDDays {
    private int result;

    /*
    这是我一开始的想法，暴力遍历，来得到 result。
    时间复杂度为 O(n^d)，过不了
     */
    public int shipWithinDays(int[] weights, int D) {
        result = Integer.MAX_VALUE;
        dfs(weights, 0, D, 0);
        return result;
    }

    private void dfs(int[] weights, int idx, int remain, int max) {
        if (remain == 0 && idx == weights.length)
            result = Math.min(result, max);
        if (remain == 0)
            return;
        int cur = 0;
        for (int i = idx; i < weights.length; i++) {
            cur += weights[i];
            max = Math.max(max, cur);
            dfs(weights, i + 1, remain - 1, max);
        }
    }

    /*
    这是答案中的办法，二分法
     */
    public int shipWithinDaysTwo(int[] weights, int D) {
        int left = 0, right = 0;
        for (int weight: weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        while (left < right) {
            //System.out.println("left = " + left + ", right = " + right);
            int mid = left + (right - left) / 2;
            //System.out.print("mid = " + mid);
            int day = checkDays(weights, mid);
            //System.out.println(", need " + day + " days");
            if (day > D) { // 说明 mid 不够，答案在 [mid + 1, right] 中
                left = mid + 1;
            }
            else {  // 答案在 [left, mid] 中
                right = mid;
            }
        }
        return left;
    }

    private int checkDays(int[] weights, int max) {
        int result = 1, cur = 0;
        for (int i = 0; i < weights.length; i++) {
            if (cur + weights[i] <= max) {
                cur += weights[i];
            }
            else {
                result += 1;
                cur = weights[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CapacityToShipWithinDDays capacityToShipWithinDDays = new CapacityToShipWithinDDays();
        capacityToShipWithinDDays.shipWithinDaysTwo(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);
    }
}
