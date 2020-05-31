

/**
 * _4_寻找两个正序数组的中位数
 */
public class _4_寻找两个正序数组的中位数 {

    class Solution {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int size1 = nums1.length;
            int size2 = nums2.length;
            if (size2 > size1)
                return findMedianSortedArrays(nums2, nums1);

            int lo = 0, hi = size2 * 2;
            while (lo <= hi) {
                int mid2 = (lo + hi) / 2;
                int mid1 = size1 + size2 - mid2;
                double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
                double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
                double R1 = (mid1 == size1 * 2) ? Integer.MAX_VALUE : nums1[(mid1) / 2];
                double R2 = (mid2 == size2 * 2) ? Integer.MAX_VALUE : nums2[(mid2) / 2];

                if (L1 > R2)
                    lo = mid2 + 1;
                else if (L2 > R1)
                    hi = mid2 - 1;
                else
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
            }
            return -1;
        }
    }
}