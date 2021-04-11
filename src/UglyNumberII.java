import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 264. Ugly Number II.
 * 最小堆
 * 动态规划（待解决）
 * @author LBW
 */
public class UglyNumberII {
    // 最小堆。时间复杂度 O(nlogn).
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        queue.offer(1L);
        set.add(1L);
        long num = 0;
        for (int i = 0; i < n; i++) {
            num = queue.poll();
            if (!set.contains(num * 2)) {
                set.add(num * 2);
                queue.offer(num * 2);
            }
            if (!set.contains(num * 3)) {
                set.add(num * 3);
                queue.offer(num * 3);
            }
            if (!set.contains(num * 5)) {
                set.add(num * 5);
                queue.offer(num * 5);
            }
        }
        return (int)num;
    }

    // 动态规划。十分巧妙。时间复杂度 O(n).
    //定义动态规划数组 dp[i] 代表 第 i 个丑数。
    //首先  dp[1] = 1.
    //然后，定义三个指针 p2, p3, p5，初始化为 1，代表当前指向第 p 个丑数
    //对于 dp[i]，计算 min(dp[p2]*2, dp[p3]*3, dp[p5]*5) 即为其值，然后更新相应的指针。
    public int nthUglyNumberII(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2)
                p2 += 1;
            if (dp[i] == num3)  // 这里不能用 else，因为要去重。
                p3 += 1;
            if (dp[i] == num5)
                p5 += 1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        UglyNumberII uglyNumberII = new UglyNumberII();
        uglyNumberII.nthUglyNumberII(10);
    }
}
