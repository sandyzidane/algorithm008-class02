import java.util.ArrayList;
import java.util.List;

public class _51_N皇后 {
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> res = new ArrayList<>();
            char[][] nQueens = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    nQueens[i][j] = '.';
                }
            }
            solve(res, nQueens, 0, n);
            return res;
    
        }
    
        public void solve(List<List<String>> res, char[][] nQueens, int row, int n) {
            // 处理完最后一行，添加一个答案
            if (row == n) {
                addSolution(res, nQueens);
                return;
            }
    
            // 对于当前行的每一列都尝试一下放皇后
            for (int col = 0; col < n; col++) {
                if (isValid(nQueens, row, col, n)) {
                    // 当前位置可以放，那就递归看看下一行能不能放
                    nQueens[row][col] = 'Q';
                    solve(res, nQueens, row + 1, n);
                    nQueens[row][col] = '.';
                }
            }
        }
    
        public void addSolution(List<List<String>> res, char[][] nQueens) {
            List<String> matrix = new ArrayList<>();
            for (int row = 0; row < nQueens.length; row++) {
                matrix.add(new String(nQueens[row]));
            }
            res.add(matrix);
        }
    
        public boolean isValid(char[][] nQueens, int row, int col, int n) {
            // 检查竖行
            for (int i = 0; i != row; i++) {
                if (nQueens[i][col] == 'Q') {
                    return false;
                }
            }
    
            // 检查45度角对角线
            for (int i = row - 1, j = col - 1; i >=0 && j >= 0; i--, j--) {
                if (nQueens[i][j] == 'Q') {
                    return false;
                }
            }
    
            // 检查135度角对角线
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (nQueens[i][j] == 'Q') {
                    return false;
                }
            }
    
            return true;
        }
    }
}