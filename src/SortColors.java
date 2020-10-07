/**
 * 75. Sort Colors
 * @author LBW
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int num : nums) {
            counts[num] += 1;
        }
        int k = 0;
        for (int i = 0; i < counts[0]; i++) {
            nums[k++] = 0;
        }
        for (int i = 0; i < counts[1]; i++) {
            nums[k++] = 1;
        }
        for (int i = 0; i < counts[2]; i++) {
            nums[k++] = 2;
        }
    }
}
