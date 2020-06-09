package week07code.example;

/**
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-05 10:14
 */
public class TrieExample2 {

    private TrieNode trieNode;

    public TrieExample2() {
        trieNode = new TrieNode('/');
    }

    // 插入
    public void insert(char[] word) {
        TrieNode temp = this.trieNode;
        for (char c : word) {
            int index = c - 'a';
            if (temp.subTrieNode[index] == null) {
                temp.subTrieNode[index] = new TrieNode(c);
            }
            temp = temp.subTrieNode[index];
        }
        temp.isEnd = true;
    }


    // 匹配
    public boolean find(char[] pattern) {
        TrieNode temp = this.trieNode;
        for (char c : pattern) {
            int index = c - 'a';
            if (temp.subTrieNode[index] == null) {
                return false;
            }
            temp = temp.subTrieNode[index];
        }
        return true;
    }

    class TrieNode {
        public char val;
        public TrieNode[] subTrieNode;
        public boolean isEnd;

        public TrieNode(char c) {
            this.val = c;
            subTrieNode = new TrieNode[26];
        }
    }
}


