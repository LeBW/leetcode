package algorithm;

import java.util.Arrays;

/**
 * @author LBW
 */
public class HeapSort
{
    public void sort(int arr[]) {
        int len = arr.length;
        buildHeap(arr, len);
        for (int i = len-1; i > 0; i--) {
            //swap arr[0] and arr[i]
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private void buildHeap(int arr[], int n)
    {
        // Your code here
        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    private void heapify(int arr[], int n, int i)
    {
        // Your code here
        int largest = i;
        int l = 2*i + 1, r = 2*i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 5, 6, 12, 11, 13};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

