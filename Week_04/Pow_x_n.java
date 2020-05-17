public class Pow_x_n {

    class Solution {
        public double myPow(double x, int n) {
            return n > 0 ? quickMul(x, Long.valueOf(n)) : 1 / quickMul(x, Long.valueOf(n));
        }

        public double quickMul(double x, Long n) {
            if (n == 0)
                return 1.0;
            double y = quickMul(x, n / 2);
            return n % 2 == 0 ? y * y : y * y * x;
        }
    }

}