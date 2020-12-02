import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 321. Create Maximum Number
 * @author LBW
 */
public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] res = new int[k];
        // i 遍历[0, k]，逐一尝试，找最大值
        for (int i = 0; i <= k; i++) {
            if (i > nums1.length || k - i > nums2.length)
                continue;
            int[] sub1 = maxSubsequence(nums1, i);
            int[] sub2 = maxSubsequence(nums2, k - i);
            int[] curMax = merge(sub1, sub2);
            // compare res and curMax
            if (compare(res, curMax)) {
                res = curMax;
            }
        }
        return res;
    }

    /* 在nums数组中，找出按原顺序保留remain个数字时，子数字最大 */
    private int[] maxSubsequence(int[] nums, int remain) {
        int drop = nums.length - remain;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (stack.isEmpty() || num <= stack.peek() || drop == 0) {
                stack.push(num);
                continue;
            }
            while (drop > 0 && !stack.isEmpty() && num > stack.peek()) {
                stack.pop();
                drop -= 1;
            }
            stack.push(num);
        }
        int[] res = new int[remain];
        for (int i = 0; i < remain; i++) {
            res[i] = stack.pollLast();
        }
        return res;
    }

    /* 将两个数组进行合并操作，合并后的数组最大 */
    private int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m == 0)
            return nums2;
        if (n == 0)
            return nums1;
        int[] res = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (k < m + n) {
            // choose nums1[i] or nums2[j]
            int i1 = i, j1 = j;
            while (i1 < m && j1 < n && nums1[i1] == nums2[j1]) {
                i1++;
                j1++;
            }
            if (i1 >= m) {
                res[k++] = nums2[j++];
            }
            else if (j1 >= n) {
                res[k++] = nums1[i++];
            }
            else if (nums1[i1] < nums2[j1]) {
                res[k++] = nums2[j++];
            }
            else {
                res[k++] = nums1[i++];
            }
        }
        return res;
    }

    private boolean compare(int[] nums1, int[] nums2) {
        int n = nums1.length, i = 0;
        while (i < n && nums1[i] == nums2[i]) {
            i++;
        }
        if (i == n)
            return false;
        return nums2[i] - nums1[i] > 0;
    }

    public static void main(String[] args) {
        CreateMaximumNumber createMaximumNumber = new CreateMaximumNumber();
        createMaximumNumber.maxNumber(new int[]{8, 6, 9}, new int[]{1, 7, 5}, 3);
    }
}
