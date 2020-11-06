import java.util.*;

/**
 * 1356. Sort Integers by The Number of 1 Bits
 * 1. 用位运算计算Integer中二进制表示中的1的个数
 * 2. Java中自定义比较，new Comparator
 * @author LBW
 */
public class SortIntegersByBits {
    public int[] sortByBits(int[] arr) {
        List<Integer> arrs = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arrs.add(arr[i]);
        }
        arrs.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int b1 = bitCount(o1);
                int b2 = bitCount(o2);
                if (b1 != b2) {
                    return b1 - b2;
                }
                return o1 - o2;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrs.get(i);
        }
        return arr;
    }
    private int bitCount(Integer num) {
        int count = 0;
        int target = num;
        while (target != 0) {
            count += target & 1;
            target = target >> 1;
        }
        return count;
    }
}



