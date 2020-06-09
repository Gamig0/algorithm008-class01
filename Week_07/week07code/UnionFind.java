package week07code;

/**
 * 并查集的实现
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-07 20:24
 */
public class UnionFind {

    private int count;

    private int[] parent;

    public UnionFind(int n){
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p), rootQ = find(q);
        if (rootP != rootQ) {
            parent[rootP] = rootQ;
            count--;
        }
    }
}
