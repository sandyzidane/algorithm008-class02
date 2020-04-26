import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        List<Integer> result = new ArrayList<>();

        for (int i=0; i<nums1.length; i++) {
            int n1 = nums1[i];
            map.compute(n1, (k, v) -> v == null ? 1 : v + 1);
            //map.merge(n1, 1, (oldV, v) -> oldV + v);
            //map.put(n1, map.getOrDefault(n1, 0) + 1);
        }

        for (int i=0; i<nums2.length; i++) {
            int n2 = nums2[i];
            
            // if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
            if (map.getOrDefault(n2, 0) > 0) {
                result.add(n2);
                map.computeIfPresent(n2, (k, v) -> v - 1);
            }
        }

        int[] r = new int[result.size()];
        for (int i=0; i<r.length; i++) {
            r[i] = result.get(i);
        }
        return r;
    }
}
// @lc code=end

