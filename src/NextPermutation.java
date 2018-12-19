import java.util.Arrays;

/**
 * @author LBW
 */
class NextPermutation {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len-2, j=len-1;
        while (i >= 0 && nums[i] >= nums[j]) {   // >= is necessary. eg. [1,1]
            i--;j--;
        }
        if (i < 0) {
            // Such arrangement is not possible
            reverseArray(nums, 0, len-1);
        }
        else {
            //find the smallest number that is larger than nums[i]
            j = len-1;
            while (nums[j] <= nums[i])  // <= is necessary. eg. [1,5,1]
                j--;
            //swap nums[i] and nums[j]
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            //reverse the rest of the array
            reverseArray(nums, i+1, len-1);
        }
    }
    private void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
