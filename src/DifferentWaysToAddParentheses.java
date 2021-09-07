import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 241. Different Ways to Add Parentheses
 * 分治
 * @author LBW
 */
public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String expression) {
        int len = expression.length();
        int idx = 0, sign = 1, number = 0;
        if (expression.charAt(idx) == '-') {
            sign = -1;
            idx += 1;
        }
        while (idx < len && !isOperator(expression.charAt(idx))) {
            number = number * 10 + expression.charAt(idx) - '0';
            idx += 1;
        }
        if (idx == len) {
            return Collections.singletonList(sign * number);
        }
        // divide and conquer
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (isOperator(expression.charAt(i))) {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (int l: left) {
                    for (int r: right) {
                        switch (expression.charAt(i)) {
                            case '+' -> res.add(l + r);
                            case '-' -> res.add(l - r);
                            case '*' -> res.add(l * r);
                        }
                    }
                }
            }
        }
        return res;
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*';
    }
}
