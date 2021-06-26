package lcof;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Offer30. 包含 min 函数的栈
 * 思路：用一个辅助栈，专门存放最小值
 * @author LBW
 */
public class Offer30 {
    private Deque<Integer> stack; // 存放数字
    private Deque<Integer> minStack; // 存放最小值
    /** initialize your data structure here. */
    public Offer30() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        }
        else {
            minStack.push(Math.min(minStack.peek(), x));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
