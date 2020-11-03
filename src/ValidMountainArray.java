/**
 * 941. Valid Mountain Array
 * @author LBW
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        int len = A.length;
        if (len < 3)
            return false;
        int i = 0;
        while (i < len - 1 && A[i] < A[i+1]) {  // 遍历上升阶段
            i += 1;
        }
        if (i == 0 || i == len - 1) // 说明没有上升或者下降阶段
            return false;
        while (i < len - 1) { // 遍历下降阶段
            if (A[i] <= A[i+1])
                return false;
            i += 1;
        }
        return true;
    }
}
