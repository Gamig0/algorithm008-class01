package week07code.daily;

/**
 * 36. 有效的数独
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-05 21:54
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (!checkSquare(board, i, j) ||
                        !checkRowAndColumn(board, i ,j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkSquare(char[][] board, int r, int c) {
        int rMax = r / 3 * 3 + 3, cMax = c / 3 * 3 + 3;
        for (int i = rMax - 3; i < rMax; ++i) {
            for (int j = cMax - 3; j < cMax; ++j) {
                if (board[i][j] == '.' || (i == r && c == j)) {
                    continue;
                }
                if (board[i][j] == board[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkRowAndColumn(char[][] board, int r, int c) {
        for (int i = 0; i < 9; ++i) {
            if (board[i][c] == '.' || i == r) {
                continue;
            }
            if (board[i][c] == board[r][c]) {
                return false;
            }
        }
        for (int i = 0; i < 9; ++i) {
            if (board[r][i] == '.' || i == c) {
                continue;
            }
            if (board[r][i] == board[r][c]) {
                return false;
            }
        }
        return true;
    }
}
