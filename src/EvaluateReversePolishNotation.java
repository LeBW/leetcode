import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 150. Evaluate Reverse Polish Notation
 * 栈
 * @author LBW
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token: tokens) {
            if (token.equals("+")) {
                int num1 = stack.pop(), num2 = stack.pop();
                stack.push(num2 + num1);
            }
            else if (token.equals("-")) {
                int num1 = stack.pop(), num2 = stack.pop();
                stack.push (num2 - num1);
            }
            else if (token.equals("*")) {
                int num1 = stack.pop(), num2 = stack.pop();
                stack.push(num2 * num1);
            }
            else if (token.equals("/")) {
                int num1 = stack.pop(), num2 = stack.pop();
                stack.push(num2 / num1);
            }
            else {
                int idx = 0, sign = 1;
                if (token.charAt(idx) == '-') {
                    idx += 1;
                    sign = -1;
                }
                int num = 0;
                while (idx < token.length()) {
                    num = num * 10 + token.charAt(idx) - '0';
                    idx += 1;
                }
                stack.push(num * sign);
            }
        }
        return stack.pop();
    }
}
