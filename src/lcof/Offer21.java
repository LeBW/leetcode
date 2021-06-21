package lcof;

/**
 * Offer21. 调整数组顺序使奇数位于偶数前面
 * 双指针
 * @author LBW
 */
public class Offer21 {
    /*
    i 指向出现的偶数，然后在后面找奇数，进行交换
     */
    public int[] exchange(int[] nums) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            while (i < n && nums[i] % 2 == 1) { // i 指向出现的偶数
                i += 1;
            }
            int j = i;
            while (j < n && nums[j] % 2 == 0) { // j 指向 i 后面第一个奇数
                j += 1;
            }
            if (j == n) { // 说明 i 后面已经全部是偶数，可以返回了
                return nums;
            }
            // 否则需要交换
            int swap = nums[i];
            nums[i] = nums[j];
            nums[j] = swap;
        }
        return nums;
    }

    /*
    方法二：快排单路的思想，不管 i 是奇数还是偶数了，在后面直接找 奇数j，直接往前交换
     */
    public int[] exchangeTwo(int[] nums) {
        int i = 0, j = 0;
        int n = nums.length;
        while (j < n) {
            while (j < n && nums[j] % 2 == 0) {
                j++;
            }
            if (j == n) {
                break;
            }
            if (j != i) {
                int swap = nums[i];
                nums[i] = nums[j];
                nums[j] = swap;
            }
            i++;
            j++;
        }
        return nums;
    }

    /*
    方法三：快排双路的做法，left 和 right 双指针
     */
    public int[] exchangeThree(int[] nums) {

        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int swap = nums[left];
                nums[left] = nums[right];
                nums[right] = swap;
            }
        }
        return nums;
    }}
