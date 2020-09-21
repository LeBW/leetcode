package contest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LBW
 */
public class MagicPermutation {
    public boolean isMagic(int[] target) {
        int len = target.length;
        List<Integer> srcList = new ArrayList<>();
        for (int i = 1; i <= len; i++) {
            srcList.add(i);
        }
        srcList = doFirstStep(srcList);
        int idx = 0, k = 0;
        while (idx < len && srcList.get(0) == target[idx]) {
            idx += 1;
            srcList.remove(0);
        }
        // k可以确定了
        k = idx;
        if (k == 0)
            return false;
        // 继续第一步
        while (!srcList.isEmpty()) {
            srcList = doFirstStep(srcList);
            int count = 0;
            while (count < k && !srcList.isEmpty() && srcList.get(0) == target[idx]) {
                idx += 1;
                count += 1;
                srcList.remove(0);
            }
            if (count < k && !srcList.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> doFirstStep(List<Integer> list) {
        List<Integer> res = new ArrayList<>();
        int idx = 1;
        while (idx < list.size()) {
            res.add(list.get(idx));
            idx += 2;
        }
        idx = 0;
        while (idx < list.size()) {
            res.add(list.get(idx));
            idx += 2;
        }
        return res;
    }

    public static void main(String[] args) {
        MagicPermutation magicPermutation = new MagicPermutation();
        int[] test1 = new int[]{2, 4, 3, 1, 5};
        int[] test2= new int[]{5, 4, 3, 2, 1};
        int[] test3 = new int[]{2, 4, 1, 3, 5};
        System.out.println(magicPermutation.isMagic(test3));
    }
}
