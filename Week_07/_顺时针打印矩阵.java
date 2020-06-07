
public class _顺时针打印矩阵 {

    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            int row, col;
            if ((row = matrix.length) == 0 || (col = matrix[0].length) == 0)
                return new int[0];
    
            int left = 0, right = col - 1, top = 0, bottom = row - 1;
            int total = row * col;
            int[] res = new int[total];
            for (int index = 0; index < total; ) {
                for (int i = left; i <= right; i++) res[index++] = matrix[top][i];
                if (++top > bottom) break;
                for (int i = top; i <= bottom; i++) res[index++] = matrix[i][right];
                if (--right < left) break;
                for (int i = right; i >= left; i--) res[index++] = matrix[bottom][i];
                if (--bottom < top) break;
                for (int i = bottom; i >= top; i--) res[index++] = matrix[i][left];
                if (++left > right) break;
            }
            return res;
    
        }
    }

    class MySolution {
        public int[] spiralOrder(int[][] matrix) {
            int row = matrix.length;
            if (row == 0) return new int[0];
            int col = matrix[0].length;
            if (col == 0) return new int[0];
    
            int[] res = new int[row * col];
            int index = 0;
            int left = 0, right = col - 1, top = 0, bottom = row - 1;
            while (left <= right && top <= bottom) {
                for (int c = left; c <= right; c++) {
                    res[index++] = matrix[top][c];
                }
                for (int r = top + 1; r <= bottom; r++) {
                    res[index++] = matrix[r][right];
                }
                if (left < right && top < bottom) {
                    for (int c = right - 1; c > left; c--) {
                        res[index++] = matrix[bottom][c];
                    }
                    for (int r = bottom; r > top; r--) {
                        res[index++] = matrix[r][left];
                    }
                }
                left++;
                right--;
                top++;
                bottom--;
            }
            return res;
        }
    }
    
    /**
    
    从 0, 0开始，改变方向的条件，结束的条件
    如何定义“一圈” -> 四个角？
    如何计算有几圈
    1, 2, 3, 4, 13
    5, 6, 7, 8, 14
    9, 10, 11, 12, 15
    16, 17, 18, 19, 20
    21, 22, 23, 24, 25
    
    row = 3, col = 4, circle = 0 (圈数)
    左上：(0+circle, 0+circle)
    右上：(0+circle, col-1-circle)
    左下：(row-1-circle, 0+circle)
    右下：(row-1-circle, col-1-circle)
    
    */
    
}