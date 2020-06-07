
public class _朋友圈 {

    class Solution {
        public int findCircleNum(int[][] M) {
            int row = M.length;
            if (row == 0) return 0;
            int col = M[0].length;
            if (col == 0) return 0;
    
            DisjointSet ds = new DisjointSet(row);
    
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (r < c && M[r][c] == 1) {
                        ds.union(r, c);
                    }
                }
            }
    
            return ds.cnt;
    
        }
    
        class DisjointSet {
            int cnt;
            int[] parent;
    
            DisjointSet(int n) {
                this.cnt = n;
                this.parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }
            int find(int x) {
                while (parent[x] != x) {
                    parent[x] = parent[parent[x]];
                    x = parent[x];
                }
                return x;
            }
            void union(int x, int y) {
                int xRoot = find(x), yRoot = find(y);
                if (xRoot == yRoot) return;
                parent[yRoot] = xRoot;
                cnt--;
            }
        }
    }
    
}