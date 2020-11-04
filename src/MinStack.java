import java.util.Arrays;

/**
 * 155. Min Stack.
 * 辅助栈思想.
 * 用另一个栈来记录最小值，与原栈保持同步的push和pop，这样就能记录每一步的最小值。
 * 之所以不用最小堆来实现，是因为push和pop都要是常数复杂度，而堆在插入元素和弹出元素时复杂度是O(logn).
 * @author LBW
 */
public class MinStack {
    private int[] element;
    private int[] mins;
    private int size;
    private int capacity;
    /** initialize your data structure here. */
    public MinStack() {
        capacity = 16;
        element = new int[capacity];
        mins = new int[capacity];
        size = 0;
    }

    public void push(int x) {
        ensureCapacity();
        element[size] = x;
        mins[size] = size > 0 ? Math.min(mins[size-1], x) : x;
        size += 1;
    }

    public void pop() {
        if (size > 0) {
            size -= 1;
        }
    }

    public int top() {
        return size > 0 ? element[size - 1] : -1;
    }

    public int getMin() {
        return size > 0 ? mins[size - 1] : Integer.MIN_VALUE;
    }

    private void ensureCapacity() {
        if (size >= capacity) {
            capacity = capacity * 2;
            element = Arrays.copyOf(element, capacity);
            mins = Arrays.copyOf(mins, capacity);
        }
    }
}
