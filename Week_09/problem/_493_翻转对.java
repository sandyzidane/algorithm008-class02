package problem;

/**
 * _493_翻转对
 */
public class _493_翻转对 {

    class Solution {
        public int reversePairs(int[] nums) {
            int len = nums.length;
            if (len <= 0) return 0;        
            return mergeSortAndCount(nums, 0, len - 1);
        }
        public int mergeSortAndCount(int[] arr, int left, int right) {
            if (left >= right) {
                return 0;
            }
            int mid = (left + right) >> 1;
            int cnt = mergeSortAndCount(arr, left, mid) + mergeSortAndCount(arr, mid + 1, right);
            // 此时左半元素有序, 右半边也有序，但不一定左边就比右边小
            int j = mid + 1;
            for (int i = left; i <= mid; i++) {
                while (j <= right && arr[i] / 2.0 > arr[j]) {
                    j++;
                }
                cnt += j - (mid + 1);
            }
            merge(arr, left, mid, right);
            return cnt;
        }
        public void merge(int[] arr, int start, int mid, int end) {
            // 同一个数组，分成左右两半，做合并 左数组包含中间元素
            int llen = mid - start + 1;
            int rlen = end - mid;
            int[] larr = new int[llen];
            int[] rarr = new int[rlen];
    
            for (int i = 0; i < llen; i++) larr[i] = arr[start + i];
            for (int j = 0; j < rlen; j++) rarr[j] = arr[mid + 1 + j];
            int k = start, l = 0, r = 0;
            while (l < llen && r < rlen)
                arr[k++] = larr[l] < rarr[r] ? larr[l++] : rarr[r++];
            while (l < llen) arr[k++] = larr[l++];
            while (r < rlen) arr[k++] = rarr[r++];
        }
    }
    
    // 归并排序来解决
}