/**
 * 164. Maximum Gap
 * 不讲武德的办法：直接用Arrays.sort排序。时间复杂度O(nlogn)。
 * 巧妙的办法：用桶排序的思想。这里的关键是：在选取桶的长度时，需要使用数组的平均间隔，也就是 max(nums) - min(nums) / (nums.length - 1). 因为数组中的最大间隔一定大于等于这个平均间隔，所以不会出现在桶内。所以我们不需要对桶内进行排序，只需要比较前一个桶的最大值与后一个桶的最小值。（待实现）
 * @author LBW
 */
public class MaximumGap {
}
