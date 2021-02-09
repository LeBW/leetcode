/**
 * 992. Subarrays with K Different Integers.
 * 双滑动指针，区间的形式进行移动
 * @author LBW
 */
public class SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] A, int K) {
        int n = A.length;
        int l1 = 0, l2 = 0, r = 0;
        int[] count1 = new int[n + 1];
        int[] count2 = new int[n + 1];
        int cur1 =  0, cur2 = 0;
        int res = 0;
        while (r < n) {
            if (count1[A[r]] == 0) {
                cur1 += 1;
            }
            count1[A[r]] += 1;
            while (cur1 > K) {
                count1[A[l1]] -= 1;
                if (count1[A[l1]] == 0) {
                    cur1 -= 1;
                }
                l1 += 1;
            }
            if (count2[A[r]] == 0) {
                cur2 += 1;
            }
            count2[A[r]] += 1;
            while (cur2 > K - 1) {
                count2[A[l2]] -= 1;
                if (count2[A[l2]] == 0) {
                    cur2 -= 1;
                }
                l2 += 1;
            }
            res += l2 - l1;
            r += 1;
        }
        return res;
    }
}
