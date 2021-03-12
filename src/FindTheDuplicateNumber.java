/**
 * 287. Find the Duplicate Number
 * 哈希。
 * 快慢指针。
 * 二分法
 * @author LBW
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        for (int num: nums) {
            count[num] += 1;
            if (count[num] == 2)
                return num;
        }
        return 0;
    }
}
