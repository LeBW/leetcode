import java.util.Arrays;
import java.util.Comparator;

/**
 * 406. Queue Resconstruction By Height
 * 方法非常巧妙。
 * 1. 两层排序。对people，根据第一个元素反向排序，根据第二个元素正向排序。
 * 2. 然后在结果中针对people进行插入。
 * @author LBW
 */
public class QueueResconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });
        int[][] res = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            if (people[i][1] >= i) {
                res[i] = people[i];
            }
            else { // 此时需要将 people[i] 插入到下标为 people[i][1] 的位置
                System.arraycopy(res, people[i][1], res, people[i][1] + 1, i - people[i][1]);
                res[people[i][1]] = people[i];
            }
        }
        return res;
    }
}
