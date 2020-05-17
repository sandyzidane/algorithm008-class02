public class x的平方根 {

    class Solution {
        public int mySqrt(int x) {
            if (x < 1)
                return 0;

            int left = 1, right = x;
            while (left <= right && right - left > 1) {
                int mid = left + (right - left) / 2;
                int divide = x / mid;
                if (divide == mid)
                    return divide;
                else if (divide > mid)
                    left = mid;
                else
                    right = mid;
            }
            return left;
        }
    }

}