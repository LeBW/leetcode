import java.util.*;

/**
 * 381. Insert Delete GetRandom O(1) - Duplicates allowed
 * 列表 + 哈希表
 * 注意在删除元素的时候，为了保证其他元素的索引不变，需要将待删除的元素与列表末尾元素交换后，再删除。（同时也要修改列表末尾元素所对应Set中的索引）
 * @author LBW
 */
public class RandomizedCollection {
    private List<Integer> list;
    private Map<Integer, Set<Integer>> map;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        int idx = list.size() - 1;
        if (map.containsKey(val)) {
            Set<Integer> set = map.get(val);
            set.add(idx);
            return false;
        }
        else {
            Set<Integer> set = new HashSet<>();
            set.add(idx);
            map.put(val, set);
            return true;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        Set<Integer> set = map.get(val);
        int idx = set.iterator().next();
        // 为了不改变索引，需要把待删除的与最后一个元素交换位置，然后删除
        int lastIdx = list.size() - 1;
        Set<Integer> lastSet = map.get(list.get(lastIdx));
        list.set(idx, list.get(lastIdx));
        list.set(lastIdx, val);
        list.remove(lastIdx);

        set.remove(idx);
        if (set.isEmpty()) {
            map.remove(val);
        }
        lastSet.remove(lastIdx);
        lastSet.add(idx);

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }

    public static void main(String[] args) {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        randomizedCollection.insert(0);
        randomizedCollection.insert(1);
        randomizedCollection.remove(0);
        randomizedCollection.insert(2);
        randomizedCollection.remove(1);
        randomizedCollection.getRandom();
    }
}
