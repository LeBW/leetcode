import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 227. Basic Calculator II
 * 基本原则：用栈存储操作数，遇到 * 或者 / 时，直接运算，得结果入栈；遇到 + - 时，加上符号再入栈
 * 最后再将栈清空即可。
 * @author LBW
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        char preSign = '+';  //
        int len = s.length();
        int i = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        while (i < len) {
            if (s.charAt(i) == ' ') {
                i += 1;
                continue;
            }
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int num = 0;
                while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + s.charAt(i) - '0';
                    i += 1;
                }
                if (preSign == '+') {
                    stack.push(num);
                }
                else if (preSign == '-') {
                    stack.push(-num);
                }
                else if (preSign == '*'){
                    int cur = stack.pop();
                    stack.push(cur * num);
                }
                else {
                    int cur = stack.pop();
                    stack.push(cur / num);
                }
            }
            else {
                preSign = s.charAt(i);
                i += 1;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
