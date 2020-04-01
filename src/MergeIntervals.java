import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Merge Intervals <a href="https://leetcode-cn.com/problems/merge-intervals/">Description</a>
 * @author LBW
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1)
            return intervals;

        //sort by the first element.
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int num = intervals.length;
        ArrayList<int[]> results = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < num; i++) {
            if (intervals[i][0] > end) {
                results.add(new int[]{start, end});
                start = intervals[i][0];
                end = Integer.max(intervals[i][1], end);
            }
            else { // merge
                end = intervals[i][1];
            }
        }
        // add the last element.
        results.add(new int[]{start ,end});

        // store the ArrayList into the array.
        return results.toArray(intervals);
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{2, 6}, {1, 3}, {8, 10}, {15, 18}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        mergeIntervals.merge(test);
    }
}
