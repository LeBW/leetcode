import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 315. Count of Smaller Numbers After Self
 * 1. 用归并排序的思想，找比目标值小的右边数字。具体来说：在merge的时候，如果选择了左边的某个数，那么说明右边中已经被选出的数字都比它小。利用这个性质可以找出比他小的数字数目。 总的时间复杂度是O(nlgn)，空间复杂度O(n)
 * 2. 用了索引数字的思想。也就是，我们新建一个索引数组[0,1,2,...,n-1]。然后在排序的时候，不改变nums数组本身，而是改变索引数组，这样的话，可以保留数字在原数组中的位置。当然，我们也可以用一个二维数组，第二维存放数字在原数组中的位置，道理是一样的。
 * @author LBW
 */
public class CountOfSmallerNumbers {

    ArrayList<Integer> result = new ArrayList<>();  //结果列表
    int[] indexArr;   //索引数组
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;  // 初始化结果列表
        for (int i = 0; i < len; i++) {
            result.add(0);
        }
        indexArr = new int[len]; //初始化索引数组
        for (int i = 0; i < len; i++) {
            indexArr[i] = i;
        }
        mergeSort(nums, 0, len - 1);  //开始归并排序
        return result;
    }

    void mergeSort(int[] nums, int start, int end) {
        if (end - start < 1) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid+1, end);
        // start to merge.
        int[] tempIndexArr = Arrays.copyOf(indexArr, indexArr.length);  // 临时数组，用来存放原顺序
        int i = start, j = mid + 1, k = start;
        while (i <= mid && j <= end) {
            if (nums[tempIndexArr[i]] <= nums[tempIndexArr[j]]) {
                indexArr[k] = tempIndexArr[i++];
                result.set(indexArr[k], result.get(indexArr[k]) + j - mid - 1);
                k++;
            }
            else {
                indexArr[k++] = tempIndexArr[j++];
            }
        }
        while (i <= mid) {
            indexArr[k] = tempIndexArr[i++];
            result.set(indexArr[k], result.get(indexArr[k]) + j - mid - 1);
            k++;
        }
        while (j <= end) {
            indexArr[k++] = tempIndexArr[j++];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 2, 6, 1};
        CountOfSmallerNumbers countOfSmallerNumbers = new CountOfSmallerNumbers();
        System.out.println(countOfSmallerNumbers.countSmaller(a));
    }
}
