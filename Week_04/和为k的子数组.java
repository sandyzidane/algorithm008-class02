import java.util.HashMap;
import java.util.Map;

public class 和为k的子数组 {

    class Solution {
        public int subarraySum(int[] nums, int k) {
            // 循环能解决吗 - 感觉有点像字符串匹配的问题

            // 关键要求：连续的子数组

            // 是不是先排个序比较好操作

            // HashMap呢？能在什么时候用上？

            // 从第i个位置到第j个位置的和：sum(i, j) = sum(0, j) - sum(0, i)

            // 先遍历数组，把 sum(0, x), x: 0 -> n-1 都算一遍，放进HashMap
            // Map<Integer, Integer> sumAt = new HashMap<>();
            // for (int idx = 0; idx < nums.length; i++) {
            // int preSum = sumAt.getOrDefault(idx - 1, 0);
            // sumAt.put(idx, preSum + nums[idx]);
            // }
            // 遍历HashMap，寻找差值等于k的组合

            int sum = 0, result = 0;
            Map<Integer, Integer> presum = new HashMap<>();
            presum.put(0, 1);

            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (presum.containsKey(sum - k)) {
                    result += presum.get(sum - k);
                }
                presum.put(sum, presum.getOrDefault(sum, 0) + 1);
            }

            return result;
        }
    }

}