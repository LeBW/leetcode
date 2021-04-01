import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1006. Clumsy Factorial
 * 用栈存储操作数，遍历 N到 1
 * 1. 遇到 * 或者 / 时，取栈顶元素 * 或者 / 当前元素。
 * 2. 遇到 + 或者 - 时，将当前元素（或相反数）入栈。
 *
 * 最后，将栈中所有元素相加，即可。
 * @author LBW
 */
public class ClumsyFactorial {
    public int clumsy(int N) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(N);
        char[] ops = new char[]{'*', '/', '+', '-'};
        int idx = 0;
        while (--N > 0) {
            char op = ops[idx];
            idx = (idx + 1) % 4;
            if (op == '*') {
                stack.push(stack.pop() * N);
            }
            else if (op == '/') {
                stack.push(stack.pop() / N);
            }
            else if (op == '+') {
                stack.push(N);
            }
            else {
                stack.push(-N);
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
