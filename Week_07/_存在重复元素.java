import java.util.*;

public class _存在重复元素 {

    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> seen = new HashSet<>();
            for (int n : nums) {
                if (!seen.add(n))
                    return true;
            }
            return false;
        }
    }

}