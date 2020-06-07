import java.util.*;

public class _地图分析 {

    class Solution {
        public int maxDistance(int[][] grid) {
            int[] dx = new int[]{0, 0, -1, 1};
            int[] dy = new int[]{1, -1, 0, 0};
    
            int row = grid.length, col = grid[0].length;
    
            Queue<int[]> q = new LinkedList<>();
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (grid[r][c] == 1) {
                        q.offer(new int[]{r, c});
                    }
                }
            }
    
            boolean hasOcean = false;
            int[] point = null;
            while (!q.isEmpty()) {
                point = q.poll();
                int x = point[0], y = point[1];
    
                for (int i = 0; i < 4; i++) {
                    int newX = x + dx[i];
                    int newY = y + dy[i];
                    if (newX < 0 || newX >= row || newY < 0 || newY >= col || grid[newX][newY] != 0) {
                        continue;
                    }
                    grid[newX][newY] = grid[x][y] + 1;    // 直接修改原矩阵，就不用额外的状态来记录是否访问过了
                    hasOcean = true;
                    q.offer(new int[]{newX, newY});
                }
            }
    
            // 没有陆地或者没有海洋
            if (point == null || !hasOcean) {
                return -1;
            }
    
            return grid[point[0]][point[1]] - 1;
        }
    }
    
}