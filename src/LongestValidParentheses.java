import java.util.Stack;

/**
 * @author LBW
 */
public class LongestValidParentheses {
    public int longestValidParenthese(String s) {
        int len = s.length();
        if (len == 0)
            return 0;

        int[] dp = new int[len];
        dp[0] = 0;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            }
            else if (s.charAt(i-1) == '(') {
                dp[i] = i-2 >= 0 ? dp[i-2] + 2 : 2;
            }
            else if (s.charAt(i-1) == ')' && i-dp[i-1]-1 >= 0 && s.charAt(i-dp[i-1]-1) == '(') {
                dp[i] = i-dp[i-1]-2 >= 0 ? dp[i-dp[i-1]-2] + dp[i-1] + 2 : dp[i-1] + 2;
            }
            else {
                dp[i] = 0;
            }
        }
        int max = dp[0];
        for (int i = 1; i < len; i++) {
            if (dp[i] > max)
                max = dp[i];
        }
        return max;
    }
    private int stackSolution(String s) {
        int len = s.length();
        if (len == 0)
            return 0;

        //Use stack to solve the problem. (Difficult to think...)
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int result = 0;

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                else {
                    result = Math.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }
}
