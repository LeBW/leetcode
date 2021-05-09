/**
 * 1482. Minimum Number of Days to make m Bouquets
 * 用二分法可以直接解决。
 * 这里的确不是很容易想到。
 * @author LBW
 */
public class MinimumNumberOfDays {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int day: bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }
        while (low < high) {
            int day = low + (high - low) / 2;
            if (checkok(bloomDay, day, m, k)) {  // ans is in [left, mid]
                high = day;
            }
            else {  // ans is in (mid, right]
                low = day + 1;
            }
        }
        return checkok(bloomDay, low, m, k) ? low : -1;
    }

    private boolean checkok(int[] bloomDay, int day, int m, int k) {
        int cur = 0, res = 0;
        for (int i = 0; i < bloomDay.length ;i++) {
            if (bloomDay[i] > day) {
                cur = 0;
            }
            else {
                cur += 1;
                if (cur >= k) {
                    res += 1;
                    cur -= k;
                }
            }
        }
        return res >= m;
    }
}
