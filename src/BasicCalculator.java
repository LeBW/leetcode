import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 224. Basic Calculator
 * 栈。基本原则：用栈来存储左括号前面的符号，因为括号内部的所有数组都应该根据括号前面的符号来选择取反或者不取反。
 * @author LBW
 */
public class BasicCalculator {
    public int calculate(String s) {
        int num = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int sign = 1;
        stack.push(sign);
        int res = 0;
        int idx = 0;
        while (idx < s.length()) {
            char c = s.charAt(idx);
            if (c == ' ') {
                idx += 1;
                continue;
            }
            if (c == '+') {
                sign = stack.peek();
                idx += 1;
            }
            else if (c == '-') {
                sign = -stack.peek();
                idx += 1;
            }
            else if (c == '(') {
                stack.push(sign);
                idx += 1;
            }
            else if (c == ')') {
                stack.pop();
                idx += 1;
            }
            else {
                num = 0;
                while (idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
                    num = num * 10 + s.charAt(idx) - '0';
                    idx += 1;
                }
                res += sign * num;
            }
        }
        return res;
    }
}
