/**
 * There are two sorted arrays <tt>nums1</tt> and <tt>nums2</tt> of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be <tt>O(log(m+n))</tt>
 * @author LBW
 */
public class FindMedianSortedArrays {
    /**
     *
     * @return the median number
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int mid = (len1 + len2) / 2;
        int p = 0, q = 0;
        int cur = 0;
        for (int i = 0; i < mid; i++) {
            if (p >= len1) {
                if (i == mid - 1)
                    cur = nums2[q];
                q++;
            }
            else if (q >= len2) {
                if (i == mid - 1)
                    cur = nums1[p];
                p++;
            }
            else if (nums1[p] < nums2[q]) {
                if (i == mid - 1)
                    cur = nums1[p];
                p++;
            }
            else {
                if (i == mid - 1)
                    cur = nums2[q];
                q++;
            }
        }
        int next = 0;
        if (p >= len1)
            next = nums2[q];
        else if (q >= len2)
            next = nums1[p];
        else if (nums1[p] < nums2[q])
            next = nums1[p];
        else
            next = nums2[q];
        if ((len1 + len2) % 2 == 1)
            return next;
        else {
            return (cur + next) / 2.0;
        }
    }

    public static void main(String[] args) {
        FindMedianSortedArrays findMidianSortedArrays = new FindMedianSortedArrays();
        double result = findMidianSortedArrays.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        System.out.println(result);
    }
}
