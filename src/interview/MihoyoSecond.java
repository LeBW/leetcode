package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 字符串笛卡尔积，输入包含多个大括号的字符串，例如"{abc,def}{gh,ijk}.."，相邻大括号求字符串笛卡尔积，输出"{abcgh,abcijk,defgh,defijk}.."，最终多个大括号可以计算得到一个大括号，实现该运算
 * 思路：有点像全排列的思想，递归（回溯）
 * @author LBW
 */
public class MihoyoSecond {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        //System.out.println(a);
        //String input = "{abc,def}{gh,ijk}";
        List<List<String>> elements = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (char c: input.toCharArray()) {
            if (c == '{') {
                cur = new ArrayList<>();
            }
            else if (c == '}') {
                cur.add(builder.toString());
                builder = new StringBuilder();
                elements.add(cur);
            }
            else if (c == ',') {
                cur.add(builder.toString());
                builder = new StringBuilder();
            }
            else {
                builder.append(c);
            }
        }
        List<String> res = compute(elements);
        //output
        StringBuilder ans = new StringBuilder();
        ans.append("{");
        for (int i = 0; i < res.size() - 1; i++) {
            ans.append(res.get(i));
            ans.append(",");
        }
        ans.append(res.get(res.size() - 1));
        ans.append("}");
        System.out.println(ans);
    }

    private static List<String> compute(List<List<String>> elements) {
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        dfs(elements, 0, cur, res);
        return res;
    }

    private static void dfs(List<List<String>> elements, int idx, StringBuilder cur, List<String> res) {
        if (idx == elements.size()) {
            res.add(cur.toString());
            return;
        }
        List<String> strs = elements.get(idx);
        for (String s: strs) {
            int len = s.length();
            cur.append(s);
            dfs(elements, idx + 1, cur, res);
            cur.delete(cur.length() - len, cur.length());
        }
    }
}
