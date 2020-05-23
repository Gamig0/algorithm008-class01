package week04code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * @author Gamigo
 * @version 1.0
 * @date 2020-05-11 21:50
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * 方法一：bfs
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return result;
        }
        q.add(root);
        while (!q.isEmpty()) {
            int count = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < count; ++i) {
                TreeNode t = q.remove();
                temp.add(t.val);
                if (t.left != null) {
                    q.add(t.left);
                }
                if (t.right != null) {
                    q.add(t.right);
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

    TreeNode(int x) {
        val = x;
    }
}