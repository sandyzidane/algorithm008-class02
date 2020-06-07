
/**
 * 不能使用 乘除法、for、while、if、else、switch、case、及条件判断语句（A ? B : C）
 */
public class _求1到n的和 {
    
    class Solution {
        public int sumNums(int n) {
            boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
            return n;
        }
    }
    
}