/**
 * 60. Permutation Sequence
 * @author LBW
 */
public class PermutationSequence {
    private int idx;
    private String result;
    public String getPermutation(int n, int k) {
        boolean[] isUsed = new boolean[n+1];
        StringBuilder cur = new StringBuilder();
        idx = 0;
        dfs(cur, isUsed, n, k);
        return result;
    }

    private boolean dfs(StringBuilder cur, boolean[] isUsed, int n, int k) {
        if (cur.length() == n) {
            idx += 1;
            if (idx == k) {
                result = cur.toString();
                return true;
            }
            else {
                return false;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (isUsed[i]) {
                continue;
            }
            cur.append(i);
            isUsed[i] = true;
            if (dfs(cur, isUsed, n, k))
                return true;
            //false, backtrack
            isUsed[i] = false;
            cur.deleteCharAt(cur.length()-1);
        }
        return false;
    }
}
