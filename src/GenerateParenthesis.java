import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 方法二：动态规划。主要思想是：求得 0～n-1 的所有括号组合后，只需要：
 * 1. 初始化 p = 0, q = n-1.
 * 2. 将 (p)q 作为 n 中的结果
 * 3. 遍历 p 从 0 ～ n-1, q 从 n-1 ~ 0 即可。
 * @author LBW
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();

        getStrings("", 0, n, results);

        return results;
    }

    private void getStrings(String cur, int stack, int n, List<String> results) {
        //if length is 2n, return the string.
        if (cur.length() == 2*n) {
            results.add(cur);
            return;
        }
        //if the stack is zero, means that there is no remaining '(' in string, so we can only add a '('.
        if (stack == 0) {
            getStrings(cur+'(', stack+1, n, results);
        }

        else {
            if (charCount('(', cur) < n)
                getStrings(cur+'(', stack+1, n, results);
            getStrings(cur + ')', stack-1, n, results);
        }
    }

    private int charCount(char c, String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (c == s.charAt(i))
                count++;
        }
        return count;
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public List<String> generateParenthesisTwo(int n) {
        List<List<String>> list = new ArrayList<>();
        list.add(Collections.singletonList(""));
        list.add(Collections.singletonList("()"));
        for (int i = 2; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            int p = 0, q = i - 1;
            while (p < i) {
                for (int k1 = 0; k1 < list.get(p).size(); k1 ++) {
                    for (int k2 = 0; k2 < list.get(q).size(); k2++) {
                        StringBuilder builder = new StringBuilder();
                        builder.append("(");
                        builder.append(list.get(p).get(k1));
                        builder.append(")");
                        builder.append(list.get(q).get(k2));
                        cur.add(builder.toString());
                    }
                }
                p += 1;
                q -= 1;
            }
            list.add(cur);
        }
        return list.get(n);
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesisTwo(3));
    }
}
