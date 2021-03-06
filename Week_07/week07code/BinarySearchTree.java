package week07code;

/**
 * 「数据结构与算法」专栏 第24讲
 * 二叉查找树第实现
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-09 11:09
 */

public class BinarySearchTree {

    private Node tree;

    /**
     * 查找
     * @param data
     * @return
     */
    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (data < p.data) p = p.left;
            else if (data > p.data) p = p.right;
            else return p;
        }
        return null;
    }


    /**
     * 插入
     * @param data
     */
    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else { // data < p.data
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    /**
     * 删除
     * @param data
     */
    public void delete(int data) {
        // p指向要删除的节点，初始化指向根节点
        Node p = tree;
        // pp记录的是p的父节点
        Node pp = null;
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) p = p.right;
            else p = p.left;
        }

        // 没有找到
        if (p == null) return;

        // 要删除的节点有两个子节点，查找右子树中最小节点（也可以用左子树最大节点）
        if (p.left != null && p.right != null) {
            Node minP = p.right;
            // minPP表示minP的父节点
            Node minPP = p;
            // 找柚子树中最小第节点
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            // 将minP的数据替换到p中
            p.data = minP.data;
            // 下面就变成了删除minP了
            p = minP;
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        Node child; // p的子节点
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null;

        // 删除的是根节点
        if (pp == null) tree = child;
        else if (pp.left == p) pp.left = child;
        else pp.right = child;
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
