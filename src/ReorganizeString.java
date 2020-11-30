import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 767. Reorganize String
 *  贪心算法。利用最大堆将字母及其出现次数存储起来。
 *  每次从堆中去除最大字母加入结果中，然后将此字母保存后请出队列。
 * @author LBW
 */
public class ReorganizeString {
    class Letter {
        char ch;
        int count;

        public Letter(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String reorganizeString(String S) {
        // init a max-heap.
        PriorityQueue<Letter> pq = new PriorityQueue<>(new Comparator<Letter>() {
            @Override
            public int compare(Letter o1, Letter o2) {
                return o2.count - o1.count;
            }
        });
        int[] counts = new int[26];
        for (int i = 0; i < S.length(); i++) {
            counts[S.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] == 0)
                continue;
            if (counts[i] > S.length() / 2) {
                return "";   // 出现最多次数的字母出现次数超过总次数的一半，此时是没有结果的。
            }
            pq.offer(new Letter((char)('a' + i), counts[i]));
        }
        // reorganize the String
        StringBuilder res = new StringBuilder();
        Letter prev = null;
        while (!pq.isEmpty()) {
            // 取出当前出现次数最多的字母，离开队列，加入结果中
            Letter cur = pq.poll();
            res.append(cur.ch);
            cur.count -= 1;
            // 如果上次被请出队列的元素还有count，则重新加入队列
            if (prev != null && prev.count > 0) {
                pq.offer(prev);
            }
            prev = cur;
        }
        return res.toString();
    }
}
