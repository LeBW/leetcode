import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 464. Can I Win
 * @author LBW
 * 记忆化回溯(动态规划）
 * 博弈DP问题
 */
public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal)
            return true;
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal)
            return false;
        int[] state = new int[maxChoosableInteger+1];
        Map<String, Boolean> memo = new HashMap<>();
        boolean res = dfs(state, memo, maxChoosableInteger, desiredTotal);
        return res;
    }

    private boolean dfs(int[] state, Map<String, Boolean> memo, int maxChoosableInteger, int desiredTotal) {
        String key = Arrays.toString(state);  // 这里一定不能是 state.toString()，否则是Java默认的类名+地址 字符串
        if (memo.containsKey(key))
            return memo.get(key);
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if (state[i] == 1)
                continue;
            // choose and backtrack
            state[i] = 1;
            // i比目标大，或者选择后对手会输，那么就进入赢的情况。
            if (i >= desiredTotal || !dfs(state, memo, maxChoosableInteger, desiredTotal - i)) {
                memo.put(key, true);
                state[i] = 0;
                return true;
            }
            // 注意即使没有赢，也要回溯
            state[i] = 0;
        }
        // 所有选择都尝试后都不能确保赢，那么就输。
        memo.put(key, false);
        return false;
    }

    public static void main(String[] args) {
        CanIWin canIWin = new CanIWin();
        canIWin.canIWin(10, 40);
    }
}
