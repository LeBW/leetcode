import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 402. Remove K Digits
 * 考虑删掉哪k个数字后，剩下的数值最小。
 * 对num的数字进行从左到右的遍历，当遍历到的数字比前一个数字小的时候，将前一个数字删掉。（因为此时前一个数字比当前数字大，考虑到删掉k个数后的数字位数相同，所以要删的话，就要删前面的数字）
 * 本质上来讲，就是单调递增栈的做法。
 * @author LBW
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            while (k > 0 && !stack.isEmpty() && c < stack.peek()) {
                stack.pop();
                k -= 1;
            }
            if (stack.isEmpty() && c == '0')  // ignore leading zero.
                continue;
            stack.push(c);
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k -= 1;
        }
        if (stack.isEmpty())
            return "0";
        // chars in the stack is the answer.
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            char c = stack.pollLast();
            builder.append(c);
        }
        return builder.toString();
    }
}
