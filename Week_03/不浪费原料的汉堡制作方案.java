import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/number-of-burgers-with-no-waste-of-ingredients/
 */
public class 不浪费原料的汉堡制作方案 {
    
    class Solution {
        public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
            if (tomatoSlices % 2 != 0 
                || tomatoSlices < cheeseSlices * 2 || cheeseSlices * 4 < tomatoSlices) {
                return new ArrayList<>();
            }
            return Arrays.asList(
                tomatoSlices / 2 - cheeseSlices, 
                cheeseSlices * 2 - tomatoSlices / 2
            );
        }
    }
}