public class SearchA2dMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {1,3,5,7},
            {10,11,16,20},
            {23,30,34,50}
        };
        int target = 13;

        System.out.println(new SearchA2dMatrix().new Solution().searchMatrix(matrix, target));
    }

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int row = matrix.length;
            if (row <= 0) return false;
            int col = matrix[0].length;
    
            // 使用每行的头部元素来比较，确定在哪一行
            int left = 0, right = row - 1;
            while (left < right) {
                int midRow = left + (right - left) / 2;
                int rowStart = matrix[midRow][0], rowEnd = matrix[midRow][col - 1];
                // 往上面的行去找
                if (target < rowStart) right = midRow - 1;
                // 往下面的行去找
                else if (target > rowEnd) left = midRow + 1;
                // 就在当前行
                else {
                    if (target == rowStart || target == rowEnd) return true;
                    else {
                        left = midRow;
                        right = midRow;
                    }
                }
            }
    
            int targetRow = left;
            int lo = 0, hi = col - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (matrix[targetRow][mid] == target) return true;
                else if (matrix[targetRow][mid] < target) lo = mid + 1;
                else hi = mid - 1;
            }
    
            return false;
        }
    }
    
}