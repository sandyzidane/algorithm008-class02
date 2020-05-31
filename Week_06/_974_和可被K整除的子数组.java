import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/** * 974. 和可被 K 整除的子数组 */
public class _974_和可被K整除的子数组 {

    public static void main(String[] args) {

        int A[] = new int[] { 4, 5, 0, -2, -3, 1 };
        int K = 5;
        int r = new _974_和可被K整除的子数组().new Solution().subarraysDivByK(A, K);
        System.out.println(r);
    }

    class Solution {
        public int subarraysDivByK(int[] A, int K) {
            System.out.println(Arrays.stream(A).mapToObj(String::valueOf).collect(Collectors.joining(",", "[", "]")));
            Map<Integer, Integer> record = new HashMap<>();
            record.put(0, 1);
            int sum = 0, ans = 0;
            for (int a : A) {
                sum += a;
                int modulus = (sum % K + K) % K;
                int same = record.getOrDefault(modulus, 0);
                ans += same;
                System.out.printf("a: %s, sum: %s, modulus: %s, same: %s, ans: %s\n", a, sum, modulus, same, ans);
                record.put(modulus, same + 1);
            }
            return ans;
        }
    }
}