package lcof;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Offer 59 - II 队列的最大值
 * 经典的双端单调队列题目
 * @author LBW
 */
public class Offer59II {
    private Queue<Integer> queue;
    private Deque<Integer> maxQueue;

    public Offer59II() {
        queue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        if (queue.isEmpty()) {
            return -1;
        }
        return maxQueue.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
            maxQueue.pollLast();
        }
        maxQueue.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        if (queue.peek().equals(maxQueue.peek())) {
            maxQueue.poll();
        }
        return queue.poll();
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
