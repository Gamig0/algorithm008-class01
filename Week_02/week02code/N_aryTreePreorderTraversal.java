package week02code;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-22 09:56
 */
public class N_aryTreePreorderTraversal {

    /**
     * 方法一：递归法前序遍历N叉树
     * 先将当前节点值添加到结果集，
     * 依次遍历自节点，重复上一步。
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    private void preOrder(Node root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            for (Node child : root.children) {
                preOrder(child, result);
            }
        }
    }
}
