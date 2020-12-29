/**
 * 330. Patching Array
 * 贪心。
 * @author LBW
 */
public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        /*
        * curIdx：当前在nums中的索引
        * res：最后添加的个数
        * */
        int len = nums.length,  curIdx = 0, res = 0;
        // curMax：指代当前[1,curMax]区间内都可以取到
        long curMax = 0;
        while (curMax < n) {
            if (curIdx < len && nums[curIdx] <= curMax + 1) { //此时可以使用nums[curIdx]进一步扩充curMax范围
                curMax = curMax + nums[curIdx];
                curIdx += 1;
            }
            else {  // 此时说明curMax+1不能在原数组中得到，需要补充 curMax + 1 这个数字，然后更新 curMax
                res += 1;
                curMax = curMax + curMax + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PatchingArray patchingArray = new PatchingArray();
        patchingArray.minPatches(new int[]{1, 3}, 6);
    }
}
