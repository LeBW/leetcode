package interview;

import java.util.*;

public class ShopeeFirst {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     *
     * @param s string字符串
     * @return string字符串一维数组
     */
    public String[] permutation(String s) {
        // write code here
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder cur = new StringBuilder();
        List<String> res = new ArrayList<>();
        boolean[] isVisited = new boolean[chars.length];
        backTrace(chars, 0, cur, res, isVisited);
        String[] ans = new String[0];
        return res.toArray(ans);
    }

    private void backTrace(char[] chars, int idx, StringBuilder cur, List<String> res, boolean[] isVisited) {
        if (idx == chars.length) {
            res.add(cur.toString());
            return;
        }
        for (int j = 0; j < chars.length; j++) {
            if (isVisited[j] || (j > 0 && !isVisited[j - 1] && chars[j] == chars[j - 1])) {
                continue;
            }
            isVisited[j] = true;
            cur.append(chars[j]);
            backTrace(chars, idx + 1, cur, res, isVisited);
            cur.deleteCharAt(cur.length() - 1);
            isVisited[j] = false;
        }
    }

    public static void main(String[] args) {
        ShopeeFirst shopeeFirst = new ShopeeFirst();
        System.out.println(Arrays.toString(shopeeFirst.permutation("abcdd")));
    }
}
