import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 232. Implement Queue Using Stacks
 * 两个栈，模拟队列
 * 1. 入栈的时候全部入 stack1
 * 2. 出栈的时候，看看 stack2 是不是空。如果是空的话，把 stack1 里的元素全部倒进去。然后从 stack2 里面输出一个元素。
 * @author LBW
 */
public class ImplementQueueUsingStacks {
    Deque<Integer> firstStack;
    Deque<Integer> secondStack = new ArrayDeque<Integer>();
    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        firstStack = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        firstStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (secondStack.isEmpty()) {
            while (!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }
        return secondStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (secondStack.isEmpty()) {
            while (!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }
        return secondStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return firstStack.isEmpty() && secondStack.isEmpty();
    }
}
