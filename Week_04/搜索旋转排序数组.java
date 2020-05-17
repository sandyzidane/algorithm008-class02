public class 搜索旋转排序数组 {

    class Solution {
        public int search(int[] nums, int target) {
            if (nums.length == 0)
                return -1;
            int len = nums.length, lo = 0, high = len - 1;

            while (lo <= high) {
                int mid = lo + (high - lo) / 2;
                if (nums[mid] == target)
                    return mid;

                if (target >= nums[0]) {
                    if (nums[mid] < nums[0]) {
                        nums[mid] = Integer.MAX_VALUE;
                    }
                } else {
                    if (nums[mid] > nums[len - 1]) {
                        nums[mid] = Integer.MIN_VALUE;
                    }
                }

                if (nums[mid] < target) {
                    lo = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
    }

}