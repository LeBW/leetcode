/**
 * 55. Jump Game
 * @author LBW
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max)  // i已经到达不了了
                return false;
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1)
                return true;
        }
        return false;
    }
}
