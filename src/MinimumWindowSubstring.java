/**
 * 76. Minimum Window Substring
 * 滑动窗口。用i和j分别指示窗口的两端。
 * 大体思路：
 *
 * 初始化：i和j都为0.
 * while（j还没有到尾部）：
 * * 将j往右移动，直到覆盖所有需要的元素。
 * * 将i往右移动，去除不必要的部分。
 * * 计算此时的窗口长度，与之前的作比较，取最小值。
 * * 将i往右移动一位，使窗口不满足条件，然后重复第一步。
 *
 * 注意因为char是8位，所以可以用128个元素的数组代替哈希。
 * @author LBW
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] need = new int[128];
        for (char c: t.toCharArray()) {
            need[c] += 1;
        }
        int needCount = t.length();
        int res = Integer.MAX_VALUE, start = 0;
        int i = 0, j = 0;
        while (j < s.length()) {
            if (need[s.charAt(j)] > 0) {
                needCount -= 1;
            }
            need[s.charAt(j)] -= 1;
            if (needCount == 0) { // 此时说明滑动窗口里有了该有的元素
                // 尝试将i往右移，得到最小长度
                while (need[s.charAt(i)] < 0) {
                    need[s.charAt(i)] += 1;
                    i += 1;
                }
                if (j - i + 1 < res) {
                    res = j - i + 1;
                    start = i;
                }
                res = Math.min(res, j - i + 1);
                // 将i往右移动一位，循环以上步骤
                need[s.charAt(i++)] += 1;
                needCount += 1;
            }
            j += 1;
        }

        if (res == Integer.MAX_VALUE) {
            return  "";
        }
        else
            return s.substring(start, start + res);
    }
}
