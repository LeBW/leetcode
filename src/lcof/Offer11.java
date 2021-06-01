package lcof;

/**
 * Offer11. 旋转数组中的最小数字
 * 二分法。
 * @author LBW
 */
public class Offer11 {
    public int minArray(int[] numbers) {
        int n = numbers.length;
        int left = 0, right = n - 1;
        while (left < right && numbers[left] >= numbers[right]) {  // 这里如果 numbers[left] < numbers[right] 的话，说明数组已经是有序的，不用继续二分了
            int mid = left + (right - left) / 2;  // 取左中元素，因为下面有 right=mid
            if (numbers[mid] > numbers[left]) {
                left = mid + 1;
            }
            else if (numbers[mid] < numbers[left]) {
                right = mid;
            }
            else {  // 如果 numbers[mid] == numbers[left]，那么既有可能在左边，也有可能在右边，但是由于重复，我们可以确定的是可以把左边界left给去掉 （此时退化到了顺序查找）
                left = left + 1;
            }
        }
        return numbers[left];
    }
}
