package algorithm;

import java.util.Stack;

/**
 * evaluate reverse polish notation
 *
 * @author LBW
 */
public class EvalRPN {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str: tokens) {

            try{
                stack.add(Integer.decode(str));
            } catch (Exception e) {
                Integer a = stack.pop();
                Integer b = stack.pop();
                switch (str) {
                    case "+":
                        stack.add(b + a);
                        break;
                    case "-":
                        stack.add(b - a);
                        break;
                    case "*":
                        stack.add(b * a);
                        break;
                    default:
                        stack.add(b / a);
                        break;
                }
            }
        }
        return stack.pop();
    }

}
