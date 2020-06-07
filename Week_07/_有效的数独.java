import java.util.*;

public class _有效的数独 {

    class Solution {
        public boolean isValidSudoku(char[][] board) {
            int n = 9;
            Set<String> seen = new HashSet<>();
    
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == '.') continue;
                    char num = board[i][j];
                    if (!seen.add(num + " seen in row " + i)
                        || !seen.add(num + " seen in col " + j)
                        || !seen.add(num + " seen in box " + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    class Solution2 {
        public boolean isValidSudoku(char[][] board) {
            int n = 9;
            Set<String> seen = new HashSet<>();
    
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == '.') continue;
                    char num = board[i][j];
                    if (!seen.add(num + " seen in row " + i)
                        || !seen.add(num + " seen in col " + j)
                        || !seen.add(num + " seen in box " + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
    
}