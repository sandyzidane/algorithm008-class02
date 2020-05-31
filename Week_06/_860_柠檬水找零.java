/**
 * 860. 柠檬水找零
 */
public class _860_柠檬水找零 {
    
    class Solution {
        public boolean lemonadeChange(int[] bills) {
            int five = 0, ten = 0;
            for (int b : bills) {
                if (b == 5) five++;
                else if (b == 10) {five--; ten++;}
                else if (ten > 0) {ten--; five--;}
                else five -= 3;
                if (five < 0) return false;
            }
            return true;
        }
    }
}