/**
 * There are two sorted arrays <tt>nums1</tt> and <tt>nums2</tt> of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be <tt>O(log(m+n))</tt>
 * @author LBW
 */
public class FindMidianSortedArrays {
    /**
     *
     * @return the median number
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int mid = (len1 + len2) / 2;
        int p = 0, q = 0;
        int cur = 0, pre = 0;
        for (int i = 0; i <= mid; i++) {
            if (p >= len1) {
                pre = cur;
                cur = nums2[q++];
            }
            else if (q >= len2) {
                pre = cur;
                cur = nums1[p++];
            }
            else if (nums1[p] < nums2[q]) {
                pre = cur;
                cur = nums1[p++];
            }
            else {
                pre = cur;
                cur = nums2[q++];
            }
        }
        if (p == 0 && q == 0)
            return len1 < 1 ? nums2[q] : nums1[p];
        System.out.println("cur: " + cur + " pre: " + pre + " mid: " + mid + " p: " + p + " q: " + q);
        if ((len1 + len2) % 2 == 1)
            return cur;
        else {
            return (cur + pre) / 2.0;
        }
    }

    public static void main(String[] args) {
        FindMidianSortedArrays findMidianSortedArrays = new FindMidianSortedArrays();
        double reuslt = findMidianSortedArrays.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(reuslt);
    }
}
