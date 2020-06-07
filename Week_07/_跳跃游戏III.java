import java.util.*;

public class _跳跃游戏III {

    class Solution {
        public boolean canReach(int[] arr, int start) {
            // 本身就是0，直接跳到
            if (arr[start] == 0) {
                return true;
            }
    
            int len = arr.length;
            boolean[] visited = new boolean[len];
            Arrays.fill(visited, false);
            Queue<Integer> q = new LinkedList<>();
    
            q.offer(start);
            visited[start] = true;
    
            while (!q.isEmpty()) {
                int u = q.poll();
                int jumpRight = u + arr[u];
                int jumpLeft = u - arr[u];
                if (jumpRight < len && !visited[jumpRight]) {
                    if (arr[jumpRight] == 0) {
                        return true;
                    }
                    q.offer(jumpRight);
                    visited[jumpRight] = true;
                }
                if (jumpLeft >= 0 && !visited[jumpLeft]) {
                    if (arr[jumpLeft] == 0) {
                        return true;
                    }
                    q.offer(jumpLeft);
                    visited[jumpLeft] = true;
                }
            }
    
            return false;
        }
    }
    
}