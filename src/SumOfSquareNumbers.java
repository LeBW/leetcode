import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 633. Sum of Square Numbers
 * @author LBW
 */
public class SumOfSquareNumbers {
    // O(logn)，但是要用到 Set，所以时间比较长
    public boolean judgeSquareSum(int c) {
        Set<Integer> set = new HashSet<>();
        long i = 0;
        for (; i * i <= c; i++) {
            int num = (int)(i * i);
            set.add(num);
            if (set.contains(c - num))
                return true;
        }
        return false;
    }

    // O(logn)，但是很快
    public boolean judgeSquareSumTwo(int c) {
        int left = 0, right = (int)Math.sqrt(c);
        while (left <= right) {
            int num = left * left + right * right;
            if (num == c) {
                return true;
            }
            else if (num < c) {
                left += 1;
            }
            else if (num > c) {
                right -= 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SumOfSquareNumbers sumOfSquareNumbers = new SumOfSquareNumbers();
        System.out.println(System.currentTimeMillis());
        System.out.println(sumOfSquareNumbers.judgeSquareSum(2147482647));
        System.out.println(System.currentTimeMillis());
    }


    public static int getCapacity(HashSet set) {
        try {
            Field mapField = set.getClass().getDeclaredField("map");
            mapField.setAccessible(true);
            HashMap map = (HashMap) mapField.get(set);
            return getCapacity(map);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int getCapacity(HashMap map) {
        try {
            Field tableField = map.getClass().getDeclaredField("table");
            tableField.setAccessible(true);
            Object[] table = (Object[]) tableField.get(map);
            if (table == null) {
                return 0;
            }
            return table.length;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
