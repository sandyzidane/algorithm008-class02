import java.util.*;

public class _访问所有节点的最短路径 {

    class Solution {

        /**
         * 路径 state 表示当前节点和已访问节点的子集。此问题可以简化为 state 的最短路径问题，那么就可以使用广度优先搜索解决。
         */
        class State {
            //cover 表示一条路径上访问过的节点集合，head 表示当前节点。在 cover 中使用比特位表示节点的访问情况，如果 cover 的第 k 个比特位是 1，表示该路径经过了第 k 个节点。
            int cover, head;
            State(int cover, int head) {
                this.cover = cover;
                this.head = head;
            }
        }
    
    
        public int shortestPathLength(int[][] graph) {
            int N = graph.length;
            Queue<State> queue = new LinkedList<>();
            int[][] dist = new int[1<<N][N];
            for (int[] row : dist)
                Arrays.fill(row, N*N);
    
            for (int x = 0; x < N; x++) {
                queue.offer(new State(1<<x, x));
                dist[1 << x][x] = 0;
            }
    
            while (!queue.isEmpty()) {
                State node = queue.poll();
                // 根据已走过的路径和当前节点，来获取路径长度
                int d = dist[node.cover][node.head];
                // 如果已经走完了就返回长度
                if (node.cover == (1 << N) - 1)
                    return d;
                
                // 当前节点的所有连通节点
                for (int child : graph[node.head]) {
                    int cover2 = node.cover | (1 << child);
                    // 选择举例较短的
                    if (d + 1 < dist[cover2][child]) {
                        dist[cover2][child] = d + 1;
                        queue.offer(new State(cover2, child));
                    }
                }
            }
    
            return 0;
        }
    }
    
}