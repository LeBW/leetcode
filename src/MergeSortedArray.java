/**
 * 88. Merge Sorted Array
 * @author LBW
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int[] tmp = new int[m + n];
        int k = 0;
        while (i < m || j < n) {
            if (i == m) {
                tmp[k++] = nums2[j++];
            }
            else if (j == n) {
                tmp[k++] = nums1[i++];
            }
            else if (nums1[i] <= nums2[j]){
                tmp[k++] = nums1[i++];
            }
            else {
                tmp[k++] = nums2[j++];
            }
        }
        System.arraycopy(tmp, 0, nums1, 0, m + n);
    }
}
