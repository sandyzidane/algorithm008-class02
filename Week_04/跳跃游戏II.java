public class 跳跃游戏II {

    class Solution {

        public int jump(int[] nums) {
            int steps = 0, maxPosition = 0, end = 0;

            for (int i = 0; i < nums.length - 1; i++) {
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