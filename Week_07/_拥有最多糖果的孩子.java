import java.util.*;

public class _拥有最多糖果的孩子 {

    class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            if (candies.length == 0) return new ArrayList<>();
    
            int maxCandy = Integer.MIN_VALUE;
            for (int candy : candies) {
                maxCandy = Math.max(maxCandy, candy);
            }
    
            List<Boolean> res = new ArrayList<>();
            for (int candy : candies) {
                res.add((candy + extraCandies) >= maxCandy);
            }
            return res;
        }
    }
    
}