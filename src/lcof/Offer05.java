package lcof;

/**
 * 剑指offer 05. 替换空格
 * @author LBW
 */
public class Offer05 {
    // 投机取巧，利用 StringBuilder。时间复杂度O(n)，空间复杂度O(2n)
    // 按作者 C 语言的思路，应该使用替换的思路，双指针，从后往前进行替换。
    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (c == ' ') {
                builder.append("%20");
            }
            else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

}
