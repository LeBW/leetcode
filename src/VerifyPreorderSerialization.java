/**
 * 331. Verify Preorder Serialization of a Binary Tree
 * 用栈的思想，记录树里可以插入的位置。
 * 设 slot = 1， 表示一开始，树里有一个可以插入的地方。
 * 然后，遍历节点：
 * 1. 如果遇到的是 #，那么减少一个 slots
 * 2. 如果遇到的是数字，那么首先减少一个slots，然后增加两个slots
 *
 * 最后，如果slots刚好为0，说明是有效的；否则是无效的。
 * @author LBW
 */
public class VerifyPreorderSerialization {
    public boolean isValidSerialization(String preorder) {
        int slots = 1;
        int idx = 0;
        String s = preorder;
        for (; idx < s.length(); idx++) {
            if (s.charAt(idx) == ',')
                continue;
            if (s.charAt(idx) == '#') {
                if (slots > 0)
                    slots -= 1;
                else
                    return false;
            }
            else {
                if (slots == 0)
                    return false;
                int num = 0;
                while (idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
                    num = num * 10 + s.charAt(idx) - '0';
                    idx += 1;
                }
                slots += 1;
            }
        }
        return slots == 0;
    }
}
