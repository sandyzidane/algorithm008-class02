import java.util.*;

public class _蛇梯棋 {

    class Solution {
        public int snakesAndLadders(int[][] board) {
            int n = board.length;
    
            // 到位置{key}需要{value}步
            Map<Integer, Integer> dist = new HashMap<>();
            dist.put(1, 0);
    
            Queue<Integer> q = new LinkedList<>();
            q.offer(1);
    
            while (!q.isEmpty()) {
                int s = q.poll();
                if (s == n * n) return dist.get(s);
                for (int s2 = s + 1; s2 <= Math.min(n*n, s + 6); s2++) {
                    int rc = get(s2, n);
                    int r = rc / n, c = rc % n;
                    int s2Final = board[r][c] == -1 ? s2 : board[r][c];
                    if (!dist.containsKey(s2Final)) {
                        dist.put(s2Final, dist.get(s) + 1);
                        q.offer(s2Final);
                    }
                }
            }
    
            return -1;
        }
    
        private int get(int s, int n) {
            int quot = (s - 1) / n;
            int rem = (s - 1) % n;
            int row = n - 1 - quot;
            int col = row % 2 != n % 2 ? rem : n - 1 - rem;
            return row * n + col;
        }
    }
    
}