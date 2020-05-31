import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 */

public class _77_组合 {

    public static void main(String[] args) {
        int n = 10, k = 2;
        List<List<Integer>> r1 = new _77_组合().new Solution1().combine(n, k);
        List<List<Integer>> r2 = new _77_组合().new Solution2().combine(n, k);

        System.out.println(r1);
        System.out.println(r2);
    }

    class Solution2 {
        int n;
        int k;
        List<List<Integer>> res;

        public List<List<Integer>> combine(int n, int k) {
            this.n = n;
            this.k = k;
            res = new ArrayList<>();
            backtrack(1, new LinkedList<>());
            return res;
        }

        private void backtrack(int first, LinkedList<Integer> cur) {
            if (cur.size() == k) {
                res.add(new ArrayList<>(cur));
            }

            for (int i = first; i <= n; i++) {
                cur.add(i);
                backtrack(i + 1, cur);
                cur.removeLast();
            }
        }
    }

    // 回溯
    class Solution1 {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> combs = new ArrayList<>();
            combine(combs, new ArrayList<Integer>(), 1, n, k);
            return combs;
    
        }

        private void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
            if (k == 0) {
                combs.add(comb);
                return;
            }

            for (int i = start; i <= n; i++) {
                comb.add(i);
                combine(combs, comb, i + 1, n, k - 1);
                comb.remove(comb.size() - 1);
            }
        }


    }
    
}