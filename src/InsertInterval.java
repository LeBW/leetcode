import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 57. Insert Interval.
 * @author LBW
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // sort
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // Greedy Algorithm
        LinkedList<int[]> results = new LinkedList<>();
        int n = intervals.length;
        int i = 0;
        for (; i < n && intervals[i][0] <= newInterval[0]; i++) {
            results.add(intervals[i]);
        }
        if (i == 0 || newInterval[0] > intervals[i-1][1]) { // no overlap
            results.add(newInterval);
        }
        else {
            results.getLast()[1] = Math.max(results.getLast()[1], newInterval[1]);
        }

        for (; i < n; i++) {
            if (intervals[i][1] <= results.getLast()[1]) {
                continue;
            }
            if (intervals[i][0] > results.getLast()[1]) { // normal
                for (; i < n; i++) {
                    results.add(intervals[i]);
                }
                break;
            }
            else {
                results.getLast()[1] = Math.max(results.getLast()[1], intervals[i][1]);
            }
        }
        return results.toArray(new int[results.size()][2]);
    }
}
