/**
 * 705. Design HashSet
 * @author LBW
 */
public class DesignHashSet {
    final int N = 1000001;
    boolean[] values;
    /** Initialize your data structure here. */
    public DesignHashSet() {
        values = new boolean[N];
    }

    public void add(int key) {
        values[key] = true;
    }

    public void remove(int key) {
        values[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return values[key];
    }
}
