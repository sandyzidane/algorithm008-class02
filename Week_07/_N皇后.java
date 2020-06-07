import java.util.*;
import java.util.stream.Collectors;

public class _N皇后 {

    class Solution {
        boolean[] pieQ;
        boolean[] naQ;
        boolean[] colQ;
        int n;
        public List<List<String>> solveNQueens(int n) {
            pieQ = new boolean[2 * n - 1];
            naQ = new boolean[2 * n - 1];
            colQ = new boolean[n];
            this.n = n;
    
            Arrays.fill(pieQ, true);
            Arrays.fill(naQ, true);
            Arrays.fill(colQ, true);
    
            char[][] matrix = new char[n][n];
            for (char[] chars : matrix) {
                Arrays.fill(chars, '.');
            }
    
            List<List<String>> result = new ArrayList<>();
            dfs(0, matrix, result);
            return result;
        }
    
    
        private void dfs(int row, char[][] matrix, List<List<String>> result) {
            if (row == this.n) {
                result.add(convertMatrixToResult(matrix));
                return;
            }
            int colNum = matrix[0].length;
            for (int col = 0; col < colNum; col++) {
                if (positionIsOk(row, col)) {
                    colQ[col] = pieQ[row - col + n - 1] = naQ[row + col] = false;
                    matrix[row][col] = 'Q';
                    dfs(row + 1, matrix, result);
                    matrix[row][col] = '.';
                    colQ[col] = pieQ[row - col + n - 1] = naQ[row + col] = true;
                }
                
            }
        }
    
        private boolean positionIsOk(int row, int col) {
            return colQ[col] && pieQ[row - col + n - 1] && naQ[row + col];
        }
    
        private List<String> convertMatrixToResult(char[][] matrix) {
            List<String> res = new ArrayList<>();
            for (char[] row : matrix) {
                String rowRes = Arrays.asList(row)
                    .stream()
                    .map(String::new)
                    .collect(Collectors.joining());
                res.add(rowRes);
            }
            return res;
        }
    
    }
    
}