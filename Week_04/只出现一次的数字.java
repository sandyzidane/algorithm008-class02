public class 只出现一次的数字 {

    class Solution {
        public int singleNumber(int[] nums) {
            if (nums.length == 0)
                return 0;

            int r = nums[0];
            for (int i = 1; i < nums.length; i++) {
                r ^= nums[i];
            }
            return r;
        }
    }

}