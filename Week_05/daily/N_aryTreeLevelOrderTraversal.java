package week05code.daily;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N叉树的层序遍历
 * @author Gamigo
 * @version 1.0
 * @date 2020-05-22 12:02
 */
public class N_aryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new LinkedList<>();
            for (int i = 0; i < size; ++i) {
                Node temp = q.poll();
                l.add(temp.val);
                for (int j = 0; j < temp.children.size(); ++j) {
                    q.add(temp.children.get(j));
                }
            }
            result.add(l);
        }
        return result;
    }
}


// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}