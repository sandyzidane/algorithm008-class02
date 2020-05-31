/**
 * _287_寻找重复数
 */
public class _287_寻找重复数 {

    class Solution {
        public int findDuplicate(int[] nums) {

            int left = 0, right = nums.length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;

                // 统计数组内小于等于mid的数
                int cnt = 0;
                for (int n : nums) {
                    if (n <= mid) {
                        cnt++;
                    }
                }

                if (cnt > mid) {
                    // 小于等于4的个数 > 4，说明一定有重复的数字在小半边
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return left;

        }
    }
}