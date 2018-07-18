import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <a href=https://leetcode-cn.com/problems/valid-parentheses/description/>
 * Click here to see online description.
 * </a>
 *<br>
 * Use Stack to solve thr problem.
 * @author LBW
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        char[] arr = s.toCharArray();

        for (char c: arr) {
            // if c is in keySet(), push it into the stack.
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            // Now we have ')' or ']' or '}'.
            // If the stack is empty or the top of the stack is not equal to the char, return false.
            else if (stack.empty() || map.get(stack.peek()) != c )
                return false;
            else {
                //valid, pop the stack.
                stack.pop();
            }
        }

        return stack.empty();
    }
}
