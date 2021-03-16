import java.util.Deque;
import java.util.LinkedList;

/**
 * 394. Decode String
 * 栈 + 字符串操作
 * @author LBW
 */
public class DecodeString {
    public String decodeString(String s) {
        Deque<Character> stack = new LinkedList<>();
        Deque<Integer> numStack = new LinkedList<>();
        int n = s.length();
        int idx = 0;
        while (idx < n) {
            if (s.charAt(idx) == '[' || (s.charAt(idx) >= 'a' && s.charAt(idx) <= 'z')) {
                stack.push(s.charAt(idx));
                idx += 1;
            }
            else if (s.charAt(idx) == ']') {
                //start to pop
                StringBuilder builder = new StringBuilder();
                while (stack.peek() != '[') {
                    builder.insert(0, stack.pop());
                }
                stack.pop(); //pop '['
                int num = numStack.pop();
                while (num-- > 0) {
                    for (int i = 0; i < builder.length(); i++) {
                        stack.push(builder.charAt(i));
                    }
                }
                idx += 1;
            }
            else {  // is digits
                int num = 0;
                while (s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
                    num = num * 10 + s.charAt(idx) - '0';
                    idx += 1;
                }
                numStack.push(num);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }
}
