package algorithm;

import java.util.Scanner;

/**
 * @author LBW
 */
public class BinarySearch {
    public static void main (String[] args) {
        //code
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int target = scanner.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }
            System.out.println(find(arr,0, n-1, target));
        }
    }

    private static int find(int[] arr, int start, int end, int target) {
        if (start > end)
            return -1;
        int mid = (start + end) / 2;
        if (arr[mid] == target)
            return mid;
        else if (arr[mid] > target) {
            return find(arr, start, mid-1, target);
        }
        else {
            return find(arr, mid+1, end, target);
        }
    }
}
