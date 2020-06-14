package problem;
import java.util.*;

/**
 * _46_全排列
 */
public class _46_全排列 {

    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> permute(int[] nums) {
            LinkedList<Integer> track = new LinkedList<>();
            backtrack(nums, track);
            return res;
        }
    
        public void backtrack(int[] nums, LinkedList<Integer> track) {
            if (nums.length == track.size()) {
                res.add(new LinkedList<>(track));
                return;
            }
    
            for (int n : nums) {
                if (track.contains(n)) {
                    continue;
                }
                track.add(n);
                backtrack(nums, track);
                track.removeLast();
            }
        }
    }
    
}