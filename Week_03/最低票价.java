import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/minimum-cost-for-tickets/
 */
public class 最低票价 {
    class Solution {
        int[] costs;
        int[] memo = new int[366];
        Set<Integer> dayset = new HashSet<>();

        public int mincostTickets(int[] days, int[] costs) {
            this.costs = costs;
            for (int d : days)
                dayset.add(d);
            return dp(1);
        }

        public int dp(int i) {
            if (i > 365)
                return 0;
            if (memo[i] != 0)
                return memo[i];

            int ans = 0;

            if (dayset.contains(i)) {
                ans = Math.min(dp(i + 1) + costs[0], Math.min(dp(i + 7) + costs[1], dp(i + 30) + costs[2]));
            } else {
                ans = dp(i + 1);
            }
            memo[i] = ans;
            return ans;
        }
    }
}