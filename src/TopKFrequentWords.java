import java.util.*;

/**
 * 692. Top K Frequent Words
 * 前 k 个高频单词。
 * 哈希表 + 最小堆（优先级队列）
 * 看到 top k 类似的要求，就要想到最小（大）堆（优先级队列）
 * @author LBW
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        // 计算出现次数的map
        Map<String, Integer> count = new HashMap<>();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        // 定义小根堆（优先级队列）
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (count.get(s1) == count.get(s2)) {
                    return s2.compareTo(s1);  // 这里是 s2 - s1，因为最后要对其进行反转
                }
                return count.get(s1) - count.get(s2);
            }
        });
        for (String word: count.keySet()) {  //  小根堆，一直保持k个元素，多了就弹出（最小的），所以最后留下的k个就是 tok k 大的元素
            queue.offer(word);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<String> res = new ArrayList<>();
        // 弹出
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        Collections.reverse(res);   // 最后 k 个元素，弹出后是从小到大，因此需要再反转一次。
        return res;
    }
}
