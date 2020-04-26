package week02code;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-22 09:39
 */
public class BinaryTreeInorderTraversal {

    /**
     * 方法一：递归法中序遍历二叉树
     * 时间复杂度：O(n)
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private void inOrder(TreeNode root, List<Integer> result) {
        if (root != null) {
            inOrder(root.left, result);
            result.add(root.val);
            inOrder(root.right, result);
        }
    }
}