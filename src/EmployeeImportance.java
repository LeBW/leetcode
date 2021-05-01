import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 690. Employee Importance
 * 1. 用哈希表存储 员工ID -> 员工
 * 2. DFS
 * @author LBW
 */
public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e: employees) {
            map.put(e.id, e);
        }
        //dfs
        return dfs(map, id);
    }

    private int dfs(Map<Integer, Employee> map, int id) {
        Employee e = map.get(id);
        int res = e.importance;
        for (int next: e.subordinates) {
            res += dfs(map, next);
        }
        return res;
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};