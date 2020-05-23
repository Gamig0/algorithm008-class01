package week03code;

/**
 * 200. 岛屿数量
 * @author Gamigo
 * @version 1.0
 * @date 2020-05-01 22:43
 */
public class NumberOfIslands {

    /**
     * 方法一：深度优先搜索
     * 查看位置的值是否为1，
     * 如果为1，则把当前位置以及附近的1都置为0
     * 继续搜索
     * 时间复杂度：O(mn)
     * 空间复杂度：O()    // 空间复杂度是否考虑内存回收？
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        int result = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (grid[i][j] == '1') {
                    result++;
                }
                dfs(grid, i, j);
            }
        }
        return result;
    }

    public void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length
                || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}
