package lcof;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指Offer 09. 用两个栈实现队列
 * 两个栈 stack1 和 stack2.
 * 1. push 操作时，直接push进 stack1.
 * 2. pop 操作时，先看 stack2 是不是空；如果是空的话，将 stack1 所有的值都反向push进来。然后从 stack2 中pop 出一个数
 * @author LBW
 */
public class Offer09 {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    public Offer09() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty() ? -1 : stack2.pop();
    }
}
