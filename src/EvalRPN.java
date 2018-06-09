import java.util.Stack;

/**
 * @author LBW
 * evaluate reverse polish notation
 */
public class EvalRPN {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str: tokens) {
            char c = str.charAt(1);

            try{
                stack.add(Integer.decode(str));
            } catch (Exception e) {
                Integer a = stack.pop();
                Integer b = stack.pop();
                if (str.equals("+"))
                    stack.add(b+a);
                else if (str.equals("-")) {
                    stack.add(b - a);
                }
                else if (str.equals("*")) {
                    stack.add(b * a);
                }
                else
                    stack.add(b / a);
            }
        }
        return stack.pop();
    }

}
