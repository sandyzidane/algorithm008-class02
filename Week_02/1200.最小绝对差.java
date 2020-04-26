import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1200 lang=java
 *
 * [1200] 最小绝对差
 */

// @lc code=start
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> r = new ArrayList<>();
        for (int i=0; i<arr.length-1; i++) {
            minDiff = Math.min(minDiff, arr[i+1]-arr[i]);
        }
        for (int i=0; i<arr.length-1; i++) {
            if ((arr[i+1]-arr[i]) == minDiff) {
                r.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        return r;
    }
}
// @lc code=end

