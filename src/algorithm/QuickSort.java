package algorithm;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.util.Arrays;

/**
 * @author LBW
 */
public class QuickSort {

    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    /**
     * 第一个值设为pivot。
     * 两个指示变量分别在首部和尾部，往中间遍历，不停交换位置错误的元素。
     * 最后放置pivot。
     */
    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start, j = end;
        while (i < j) {
            for (; i < j && arr[j] >= pivot; j--);
            arr[i] = arr[j];

            for (; i < j && arr[i] <= pivot; i++);
            arr[j] = arr[i];
        }
        arr[i] = pivot;
        return i;
    }

    /**
     * 最后一个值设为pivot。
     * 两个指示变量i和j都初始化指向start，利用j进行数组遍历，碰到比pivot小的值时与arr[i++]交换，从而将所有比pivot小的元素移到数组的前半部分。
     * 最后将pivot放置在arr[i]处（即将arr[i]与arr[end]进行交换）.
     * 注意：这种方法i和j一定要往同一方向遍历！！！否则会造成不必要的麻烦。
     */
    private static int partitionTwo(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start, j = start;
        for (; j < end; j++) {
            if (arr[j] <= pivot) {
                //swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                // increment i.
                i = i + 1;
            }
        }
        //swap arr[i] and arr[end]
        arr[end] = arr[i];
        arr[i] = pivot;
        return i;
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int p = partitionTwo(arr, start, end);
        quickSort(arr, start, p-1);
        quickSort(arr, p+1, end);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 3, 9, 7};
        QuickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
