/**
 * https://leetcode-cn.com/problems/jump-game-ii/
 */
public class 跳跃游戏II {
    class Solution {
        public int jump(int[] nums) {
            // 在当前位置，检查后面几个位置哪一个能跳的更远
            int len = nums.length, end = 0, maxPosition = 0, steps = 0;
            for (int i = 0; i < len - 1; i++) {
                // 最远可到达的位置
                maxPosition = Math.max(maxPosition, i + nums[i]);
                if (i == end) {
                    end = maxPosition;
                    steps++;
                }
            }
            return steps;
        }
    }
}