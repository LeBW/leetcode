import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 341. Flatten Nested List Iterator
 * DFS
 * @author LBW
 */
public class FlattenNestedListIterator implements Iterator<Integer>{
    private List<Integer> values = new ArrayList<>();
    private Iterator<Integer> it;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        traverse(nestedList);
        it = values.iterator();
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    private void traverse(List<NestedInteger> nestedList) {
        for (NestedInteger ni: nestedList) {
            dfs(ni);
        }
    }

    private void dfs(NestedInteger ni) {
        if (ni.isInteger()) {
            values.add(ni.getInteger());
        }
        else {
            for (NestedInteger nni: ni.getList()) {
                dfs(nni);
            }
        }
    }
}

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
    public Integer getInteger();


    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
