import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

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
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else if (stack.isEmpty() || map.get(stack.pop()) != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
