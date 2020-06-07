import java.util.*;

public class _除自身以外数组的乘积 {

    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int len = nums.length;
            if (len <= 1)
                return nums;
    
            int[] res = new int[len];
            Arrays.fill(res, 1);
            int left = 1, right = 1;
            for (int i = 0, j = len - 1; i < len; i++, j--) {
                
                res[i] *= left;
                res[j] *= right;
                left *= nums[i];
                right *= nums[j];
            }
            return res;
    
        }
    }

    class MySolution {
        public int[] productExceptSelf(int[] nums) {
            int len = nums.length;
            if (len <= 1)
                return nums;
            int[] preProduct = new int[len];
            int[] postProduct = new int[len];
    
            for (int i = 0; i < len; i++) {
                preProduct[i] = i > 0 ? preProduct[i-1] * nums[i] : nums[i];
            }
    
            for (int i = len - 1; i >= 0; i--) {
                postProduct[i] = (i == len - 1) ? nums[len-1] : postProduct[i+1] * nums[i];
            }
    
            int[] res = new int[len];
            for (int i = 0; i < len; i++) {
                int left = i > 0 ? preProduct[i - 1] : 1;
                int right = (i < len - 1) ? postProduct[i + 1] : 1;
                res[i] = left * right;
            }
            return res;
    
        }
    }
    
    // 不能用除法 -》 前缀和 -》 前缀积？
    // preProduct[i] = nums[0] * nums[1] * ... * nums[i]
    // postProduct[i] = nums[len-1] * nums[len-2] * ... * nums[i]
    
}