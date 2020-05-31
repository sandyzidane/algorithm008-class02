
/**
 * _169_多数元素
 */
public class _169_多数元素 {

    class Solution {
        public int majorityElement(int[] nums) {
            if (nums.length == 0)
                return 0;
            // moore voting
            int me = nums[0], cnt = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == me) {
                    cnt++;
                } else {
                    cnt--;
                    if (cnt == 0) {
                        me = nums[i];
                        cnt++;
                    }
                }
            }
            return me;
        }
    }
}