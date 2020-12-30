import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1046. Last Stone Weight
 * @author LBW
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int stone: stones) {
            queue.offer(stone);
        }
        while (queue.size() > 1) {
            int y = queue.poll();
            int x = queue.poll();
            if (y != x) {
                queue.offer(y - x);
            }
        }
        if (queue.size() == 1)
            return queue.poll();
        return 0;
    }

    public static void main(String[] args) {
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        System.out.println(lastStoneWeight.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }
}
