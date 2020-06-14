package problem;

import java.util.*;

/**
 * 面试题40_最小的k个数
 */
public class 面试题40_最小的k个数 {
    

    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k <= 0) return new int[0];
            int len = arr.length;
            if (k >= len) {
                return arr;
            }
    
            return quickSearch(arr, 0, len - 1, k - 1);
        }
    
        private int[] quickSearch(int[] nums, int lo, int hi, int k) {
            int j = partition(nums, lo, hi);
            if (j == k) {
                return Arrays.copyOf(nums, j + 1);
            }
            return j > k ? quickSearch(nums, lo, j - 1, k) : quickSearch(nums, j + 1, hi, k);
        }
    
        private int partition(int[] nums, int lo, int hi) {
            int v = nums[lo];
            int i = lo, j = hi + 1;
            while (true) {
                while (++i <= hi && nums[i] < v);
                while (--j >= lo && nums[j] > v);
                if (i >= j) {
                    break;
                }
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
            }
            nums[lo] = nums[j];
            nums[j] = v;
            return j;
        }
    
        
    }
    
    // 思路1:排序后，顺序取k个就行了
    // 思路2:维护一个大小为k的大顶堆，每次碰到比堆顶更小的元素且堆满了，就  => 时间复杂度O(n)，空间复杂度可能是O(k)
    // 思路3:维护一个单调栈？？
}