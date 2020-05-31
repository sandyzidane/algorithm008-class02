import java.util.*;

/**
 * _322_零钱兑换
 */
public class _322_零钱兑换 {

    class Solution {
        public int coinChange(int[] coins, int amount) {
            // 递归？
            // int r = recur(0, coins, amount);
            // 记忆化递归?
            // dp?
            // 参与递推关系的变量：amount, coin数组
            // amount > coin中所有值: min{amount - coins[i]} + 1;
            int max = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (coin <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
            return dp[amount] == max ? -1 : dp[amount];
        }

        private int recur(int cnt, int[] coins, int amount) {
            if (amount == 0) {
                return cnt;
            }

            int[] cnts = new int[coins.length];

            for (int i = 0; i < coins.length; i++) {
                cnts[i] = Integer.MAX_VALUE;
                int coin = coins[i];
                if (coin <= amount) {
                    cnts[i] = recur(cnt + 1, coins, amount - coin);
                }
            }
            int minCnt = Integer.MAX_VALUE;
            for (int c : cnts) {
                minCnt = Math.min(minCnt, c);
            }
            return minCnt;
        }
    }
}