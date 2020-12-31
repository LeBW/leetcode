import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. Non-overlapping Intervals
 * 经典贪心算法：区间调度问题。
 * 要求最少移除掉几个区间，等于求最多选择多少个区间，使它们互不重叠。
 * 这里可以使用贪心算法，将区间按照end进行排序，然后每次尽量选择end最小的区间
 * @author LBW
 */
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 将区间按照end排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        // res表示留下多少个区间；curEnd表示当前的end在哪
        int res = 0, curEnd = Integer.MIN_VALUE;
        for (int[] interval: intervals) {
            if (interval[0] >= curEnd) { // 当start >= curEnd，说明这个区间应该选中
                res += 1;
                curEnd = interval[1];
            }
        }
        return intervals.length - res;
    }
}
