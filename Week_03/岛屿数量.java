/**
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class 岛屿数量 {
    class Solution {
        public int numIslands(char[][] grid) {
            int numOfIslands = 0;
            if (grid.length == 0) return 0;
            for (int r=0; r<grid.length; r++) {
                for (int c=0; c<grid[0].length; c++) {
                    if (grid[r][c] == '1') {
                        numOfIslands++;
                        dfs(grid, r, c);
                    }
                }
            }
            return numOfIslands;
        }
    
        public void dfs(char[][] grid, int r, int c) {
            int nr = grid.length;
            int nc = grid[0].length;
    
            grid[r][c] = '0';
            // top
            if (r - 1 >= 0 && grid[r-1][c] == '1') dfs(grid, r-1, c);
            // bottom
            if (r + 1 < nr && grid[r+1][c] == '1') dfs(grid, r+1, c);
            // left
            if (c - 1 >= 0 && grid[r][c-1] == '1') dfs(grid, r, c-1);
            // right
            if (c + 1 < nc && grid[r][c+1] == '1') dfs(grid, r, c+1);
        }
    }
}