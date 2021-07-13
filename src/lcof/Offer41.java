package lcof;

import java.util.PriorityQueue;

/**
 * Offer 41. 数据流中的中位数
 * 与中位数有关的题目，应该想到对顶堆
 *
 * @author LBW
 */
public class Offer41 {
    private PriorityQueue<Integer> maxHeap; // 大顶堆
    private PriorityQueue<Integer> minHeap;  // 小顶堆

    /**
     * initialize your data structure here.
     */
    public Offer41() {
        maxHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);
        minHeap = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        if (maxHeap.size() == minHeap.size()) {  // 需要往 bigHeap 里添加元素
            // 因为这里要保证两个堆的大小性质，所以我们不能直接往 bigHeap 添加 num，而是往 smallHeap 里添加 num，然后将 smallHeap 的堆顶加入 bigHeap
            if (minHeap.size() > 0 && minHeap.peek() < num) {
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }
        } else {  // 需要往 smallHeap 里添加元素
            if (maxHeap.size() > 0 && maxHeap.peek() > num) {
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}
