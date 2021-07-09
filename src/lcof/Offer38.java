package lcof;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Offer 38. 字符串的排列
 * DFS(回溯）
 * @author LBW
 */
public class Offer38 {
    private List<String> res;
    public String[] permutation(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        boolean[] isVisited = new boolean[n];

        dfs(cs, builder, isVisited);

        String[] ans = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private void dfs(char[] cs, StringBuilder builder, boolean[] isVisited) {
        if (builder.length() == cs.length) {
            res.add(builder.toString());
            return;
        }
        for (int i = 0; i < cs.length; i++) {
            if (!isVisited[i] && !(i > 0 && !isVisited[i - 1] && cs[i] == cs[i - 1])) {  // 这里的 !(i > 0 && !isVisited[i - 1] && cs[i] == cs[i - 1]) 就是用来去重的
                builder.append(cs[i]);
                isVisited[i] = true;
                dfs(cs, builder, isVisited);
                isVisited[i] = false;
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }
}
