package week07code;

/**
 * 208. 实现 Trie (前缀树)
 * 此为简易版的实现，建议看官方题解（TrieNode + Trie）。
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-01 10:57
 */
public class Trie {

    private boolean isEnd;
    private Trie[] subTrie;
    /** Initialize your data structure here. */
    public Trie() {
        subTrie = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie current = this;
        for (int i = 0, len = word.length(); i < len; ++i) {
            if (current.subTrie[word.charAt(i) - 'a'] == null) {
                current.subTrie[word.charAt(i) - 'a'] = new Trie();
            }
            current = current.subTrie[word.charAt(i) - 'a'];
        }
        current.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie temp = this;
        for (int i = 0, len = word.length(); i < len; ++i) {
            if (temp.subTrie[word.charAt(i) - 'a'] == null) {
                return false;
            }
            temp = temp.subTrie[word.charAt(i) - 'a'];
        }
        return temp.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie temp = this;
        for (int i = 0, len = prefix.length(); i < len; ++i) {
            if (temp.subTrie[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            temp = temp.subTrie[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}
