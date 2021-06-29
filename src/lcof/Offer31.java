package lcof;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 栈的压入、弹出序列
 * 模拟题。模拟入栈找出栈顺序
 * @author LBW
 */
public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int j = 0; // index of popped
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j += 1;
            }
        }
        return stack.isEmpty();
    }
}
