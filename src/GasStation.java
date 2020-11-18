/**
 * 134. Gas Station
 * @author LBW
 */
public class GasStation {
    /**
     * 暴力法。逐一尝试。
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            if (gas[i] < cost[i]) {
                continue;
            }
            // try with i.
            int j = i, remain = 0;
            boolean canComplete = true;
            for (int k = 0; k < n; k++) {
                remain = remain + gas[j] - cost[j];
                j = (j + 1) % n;
                if (remain < 0) {
                    canComplete = false;
                    break;
                }
            }
            if (canComplete)
                return i;
        }
        return -1;
    }

    /**
     * 方法二：很巧妙的方法，一次遍历，找到剩余油箱最低的点，在其下一个点开始就是最优的。
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuitTwo(int[] gas, int[] cost) {
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
        return remain < 0 ? -1 : (minIdx + 1) % n;
    }
}
