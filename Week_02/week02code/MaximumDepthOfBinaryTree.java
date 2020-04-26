package week02code;

/**
 * 104. 二叉树的最大深度
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-24 14:43
 */
public class MaximumDepthOfBinaryTree {



    /**
     * 方法一：递归遍历二叉树求高度：
     * 时间复杂度：O(n)
     * 空间复杂度：O(logn)    // 最坏是O(n)
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        // 如果当前节点为空，返回0
        if (root == null) {
            return 0;
        } else {
            // 如果当前节点不为空，返回子节点的最大深度+1
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
