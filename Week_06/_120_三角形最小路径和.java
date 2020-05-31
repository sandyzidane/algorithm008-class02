import java.util.*;

/**
 * _120_三角形最小路径和
 */
public class _120_三角形最小路径和 {

    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle.isEmpty())
                return 0;

            int row = triangle.size();

            // 从倒数第二行开始算
            for (int r = row - 2; r >= 0; r--) {
                List<Integer> curRow = triangle.get(r);
                List<Integer> belowRow = triangle.get(r + 1);
                // 每一行的元素，都从下一行的元素上加过来，取较小值
                int col = curRow.size();
                for (int c = 0; c < col; c++) {
                    int ele = curRow.get(c);
                    curRow.set(c, Math.min(ele + belowRow.get(c), ele + belowRow.get(c + 1)));
                }
            }

            return triangle.get(0).get(0);

        }
    }
}