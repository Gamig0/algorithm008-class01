package week02code;

/**
 * 111. 二叉树的最小深度
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-24 15:20
 */
public class MinimumDepthOfBinaryTree {

    /**
     * 方法一：递归求最小深度
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        // 如果左右孩子节点有为空的情况，返回不为空的值+1
        // 如果左右孩子均不为空，返回较小的值+1
        return (left == 0 || right == 0) ?
                left + right + 1 : Math.min(left, right) + 1;
    }

}
