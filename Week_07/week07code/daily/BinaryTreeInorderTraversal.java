package week07code.daily;

import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 递归方法中序（左根右）遍历二叉树
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-01 20:11
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inorderT(root, res);
        return res;
    }
    private void inorderT(TreeNode current, List<Integer> res) {
        if (current == null) {
            return;
        }
        inorderT(current.left, res);
        res.add(current.val);
        inorderT(current.right, res);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }