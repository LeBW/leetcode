/**
 * 514. Freedom Trail
 * @author LBW
 */
public class FreedomTrail {
    private int result;
    private int[][] memo;
    public int findRotateSteps(String ring, String key) {
        result = Integer.MAX_VALUE;
        memo = new int[ring.length()][key.length()];
        return findRotateSteps(ring, 0, key, 0);
    }


    /**
     * 方法二，记忆化递归.
     * 这里bias指的是 ring 的偏离，idx 指的是 key 的偏离。
     * 记忆化DFS，其实也是动态规划的一种，只不过是自顶向下的，便于理解。
     */
    private int findRotateSteps(String ring, int bias, String key, int idx) {
        if (idx >= key.length()) {
            return 0;
        }
        if (memo[bias][idx] != 0) {
            return memo[bias][idx];
        }
        // 说明这条路没有走过，需要计算在ring偏离bias时，key从idx开始，最后所所需的最小步数
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < ring.length(); i++) {
            if (ring.charAt(i) == key.charAt(idx)) {
                int needStep = Math.abs(bias - i);
                needStep = Math.min(needStep, ring.length() - needStep) + 1;
                result = Math.min(result, needStep + findRotateSteps(ring, i, key, idx + 1));
            }
        }
        memo[bias][idx] = result;
        return result;
    }


    /**
     *  方法一，暴力法，暴力DFS。超出时间限制。。
     */
    private void findRotateSteps(String ring, int bias, String key, int idx, int steps) {
        if (idx >= key.length()) {
            if (steps < result) {
                result = steps;
            }
            return;
        }
        // 计算按下key[idx]所需的步数
        for (int i = 0; i < ring.length(); i++) {
            if (ring.charAt(i) == key.charAt(idx)) {
                int needStep = Math.abs(bias - i);
                needStep = Math.min(needStep, ring.length() - needStep) + 1;
                findRotateSteps(ring, i, key, idx + 1, steps + needStep);
            }
        }
    }

    public static void main(String[] args) {
        FreedomTrail freedomTrail = new FreedomTrail();
        freedomTrail.findRotateSteps("godding", "godding");
    }
}
