import java.util.Arrays;

/**
 * 二分查找法。
 * 1. 对于每个house，在heaters数组中二分查找与其最接近的节点，从而找出所需的最短半径。
 * 2. 对于所有house，找出最大的最短半径。
 * 时间复杂度： O(nlogm)
 * @author LBW
 */
public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int result = 0;
        for (int i = 0; i < houses.length; i++) {
            int minR = findMinRadius(heaters, 0, heaters.length-1, houses[i]);
            if (minR > result)
                result = minR;
        }
        return result;
    }
    public int findMinRadius(int[] heaters, int start, int end, int target) {
        if (start == end) {
            return Math.abs(heaters[start]-target);
        }
        if (start + 1 == end) {
            return Math.min(Math.abs(heaters[start]-target), Math.abs(heaters[end]-target));
        }
        int mid = (start + end) / 2;
        if (heaters[mid] == target)
            return 0;
        if (heaters[mid] > target) {
            return findMinRadius(heaters, start, mid, target);
        }
        else {
            return findMinRadius(heaters, mid, end, target);
        }
    }
}
