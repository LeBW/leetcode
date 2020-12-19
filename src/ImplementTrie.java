/**
 * 208. Implement Trie
 * 前缀树
 * @author LBW
 */
public class ImplementTrie {

    static class TrieNode {
        boolean isEnded;
        TrieNode[] next;

        public TrieNode() {
            this.isEnded = false;
            this.next = new TrieNode[26];
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public ImplementTrie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (char ch: word.toCharArray()) {
            if (cur.next[ch - 'a'] == null) {
                cur.next[ch - 'a'] = new TrieNode();
            }
            cur = cur.next[ch - 'a'];
        }
        cur.isEnded = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (char ch: word.toCharArray()) {
            if (cur.next[ch - 'a'] == null)
                return false;
            cur = cur.next[ch - 'a'];
        }
        return cur.isEnded;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char ch: prefix.toCharArray()) {
            if (cur.next[ch - 'a'] == null)
                return false;
            cur = cur.next[ch - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        ImplementTrie trie = new ImplementTrie();
        trie.insert("apple");
        trie.search("apple");
        trie.search("app");
        trie.startsWith("app");
        trie.insert("app");
        trie.search("app");
    }
}
