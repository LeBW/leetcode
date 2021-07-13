package interview;

/**
 * @author LBW
 */
public class HuaweiFirst {
    // 找到剩余邮箱最低的点，下一个点就是最优的点
    private int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int remain = gas[0] - cost[0];
        int min = remain, minIdx = 0;
        for (int i = 1; i < n; i++) {
            remain = remain + gas[i] - cost[i];
            if (remain < min) {
                min = remain;
                minIdx = i;
            }
        }
        // minIdx 下一个点
        return (minIdx + 1) % n;
    }
}
