package problem;

/**
 * _1122_数组的相对排序
 */
public class _1122_数组的相对排序 {
    
    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int[] arr = new int[1001];
            int[] ans = new int[arr1.length];
            int index = 0;
            for (int n : arr1) arr[n]++;
            for (int n : arr2) {
                while (arr[n]-- > 0) {
                    ans[index++] = n;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                while (arr[i]-- > 0) {
                    ans[index++] = i;
                }
            }
            return ans;
        }
    }
}