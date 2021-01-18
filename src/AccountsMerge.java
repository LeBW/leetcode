import java.util.*;

/**
 * 721. Accounts Merge
 * 并查集。
 * 首先将所有email组成Map，然后创建一个并查集，将每个账户里面的邮件做一个union操作，就相当于成功合并了。
 * 然后创建一个map，将分类好的邮件都加进去，最后改装成题目要求的List即可。
 * @author LBW
 */
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        int emailCount = 0;
        for (List<String> account: accounts) {
            for (int i = 1; i < account.size(); i++) {
                if (!emailToIndex.containsKey(account.get(i))) {
                    emailToIndex.put(account.get(i), emailCount++);
                    emailToName.put(account.get(i), account.get(0));
                }
            }
        }
        DisjointSet disjointSet = new DisjointSet(emailCount);
        for (List<String> account: accounts) {
            String firstEmail = account.get(1);
            int firstIdx = emailToIndex.get(firstEmail);
            for (int i = 2; i < account.size(); i++) {
                disjointSet.union(firstIdx, emailToIndex.get(account.get(i)));
            }
        }
        Map<Integer, List<String>> indexToEmails = new HashMap<>();
        for (String email: emailToIndex.keySet()) {
            int idx = disjointSet.find(emailToIndex.get(email));
            List<String> emails = indexToEmails.getOrDefault(idx, new ArrayList<>());
            emails.add(email);
            indexToEmails.put(idx, emails);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> emails: indexToEmails.values()) {
            Collections.sort(emails);
            List<String> account = new ArrayList<>();
            account.add(emailToName.get(emails.get(0)));
            account.addAll(emails);
            res.add(account);
        }
        return res;
    }

    static class DisjointSet {
        int[] parent;
        int n;

        public DisjointSet(int n) {
            this.n = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int k) {
            if (parent[k] != k)
                parent[k] = find(parent[k]);
            return parent[k];
        }

        public void union(int i, int j) {
            int pi = find(i), pj = find(j);
            parent[pj] = parent[pi];
        }
    }
}
