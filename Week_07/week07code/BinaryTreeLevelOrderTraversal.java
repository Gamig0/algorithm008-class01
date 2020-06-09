package week07code;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历 第二遍
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-01 10:31
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * 方法一：BFS
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> dq = new LinkedList<>();
        dq.add(root);
        while (!dq.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            for (int i = 0, size = dq.size(); i < size; ++i) {
                TreeNode t = dq.poll();
                temp.add(t.val);
                if (t.left != null) {
                    dq.add(t.left);
                }
                if (t.right != null) {
                    dq.add(t.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}