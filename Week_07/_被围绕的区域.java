import java.util.*;

public class _被围绕的区域 {

    class Solution {
        public void solve(char[][] board) {
            int row = board.length;
            if (row == 0) return;
            int col = board[0].length;
            if (col == 0) return;
    
            boolean[][] free = new boolean[row][col];
            // dfs，从边缘的O开始，抓着一个相邻的O就开始递归
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i != 0 && i != row - 1 && j != 0 && j != col - 1) {
                        continue;
                    }
                    if (board[i][j] == 'O') {
                        free[i][j] = true;
                        dfs(i, j, free, board);
                    }
                }
            }
    
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (board[r][c] == 'O' && !free[r][c]) {
                        board[r][c] = 'X';
                    }
                }
            }
        }
    
        private void dfs(int x, int y, boolean[][] free, char[][] board) {
            int[] dx = new int[]{0, 0, -1, 1};
            int[] dy = new int[]{-1, 1, 0, 0};
    
            int row = board.length;
            int col = board[0].length;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                    continue;
                }
                if (board[nx][ny] == 'O' && !free[nx][ny]) {
                    free[nx][ny] = true;
                    dfs(nx, ny, free, board);
                }
            }
        }
    }

    class Solution2 {
        public void solve(char[][] board) {
            int[] dx = new int[]{0, 0, -1, 1};
            int[] dy = new int[]{-1, 1, 0, 0};
    
            int row = board.length;
            if (row == 0) return;
            int col = board[0].length;
            if (col == 0) return;
    
            Queue<int[]> q = new LinkedList<>();
            boolean[][] visited = new boolean[row][col];
            // 区域是否连通到外界
            boolean[][] free = new boolean[row][col];
            // 把边缘的O推进队列
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if ((r != 0 && r != row - 1) && (c != 0 && c != col - 1)) {
                        continue;
                    }
                    if (board[r][c] == 'O') {
                        q.offer(new int[]{r, c});
                        free[r][c] = true;
                        visited[r][c] = true;
                    }
                }
            }
    
            while (!q.isEmpty()) {
                // 从边缘的O开始往内搜索
                for (int size = q.size(); size > 0; size--) {
                    int[] oPosition = q.poll();
                    int x = oPosition[0];
                    int y = oPosition[1];
                    // 搜索四周的O
                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        // 超出范围了
                        if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                            continue;
                        }
                        if (board[nx][ny] == 'O' && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            free[nx][ny] = true;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
    
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (board[r][c] == 'O' && !free[r][c]) {
                        board[r][c] = 'X';
                    }
                }
            }
    
        }
    }
    
    
}