/**
 * 238. Product of Array Except Self
 * 维护两个数组L和R，其中L[i]代表i左边所有数的积，R[i]代表i右边所有数的乘积
 * 所以 res[i] = L[i] * R[i].
 * @author LBW
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] L = new int[n];
        int[] R = new int[n];
        L[0] = 1;
        for (int i = 1; i < n; i++) {
            L[i] = L[i-1] * nums[i-1];
        }
        R[n-1] = 1;
        for (int i = n - 2; i >= 0; i--){
            R[i] = R[i + 1] * nums[i+1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = L[i] * R[i];
        }
        return res;
    }
}
