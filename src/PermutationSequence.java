/**
 * 60. Permutation Sequence
 * @author LBW
 */
public class PermutationSequence {
    private int idx;
    private String result;
    private int[] factorial;

    public String getPermutation(int n, int k) {
        boolean[] isUsed = new boolean[n+1];
        StringBuilder cur = new StringBuilder();
        idx = 0;
        // init factorial array
        factorial = new int[10];
        factorial[0] = 1;
        for (int i = 1; i < 10; i++) {
            factorial[i] = factorial[i-1] * i;
        }
        // DFS
        dfs(cur, isUsed, n, k);
        return result;
    }

    private void dfs(StringBuilder cur, boolean[] isUsed, int n, int k) {
        if (cur.length() == n) {
            result = cur.toString();
            return;
        }
        int cnt = factorial[n - cur.length() - 1];
        for (int i = 1; i <= n; i++) {
            if (isUsed[i]) {
                continue;
            }
            if (cnt < k) {  // 说明不在这个分支里，直接进行剪枝
                k = k - cnt;
                continue;
            }
            cur.append(i);
            isUsed[i] = true;
            dfs(cur, isUsed, n, k);
        }
    }
}
