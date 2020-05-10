/**
 * https://leetcode-cn.com/problems/find-in-mountain-array/
 */
public class 山脉数组中查找目标值 {

    interface MountainArray {
        int get(int index);

        int length();
    }

    class Solution {
        public int findInMountainArray(int target, MountainArray mountainArr) {
            int l = 0, r = mountainArr.length() - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

            int peak = l;
            // find left part
            int targetIndex = binarySearch(mountainArr, target, 0, peak, 1);
            if (targetIndex != -1) {
                return targetIndex;
            }
            // find right part
            return binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1, -1);
        }

        public int binarySearch(MountainArray mountainArr, int target, int l, int r, int reverse) {
            target *= reverse;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                int cur = mountainArr.get(mid) * reverse;
                if (cur == target) {
                    return mid;
                } else if (cur < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return -1;
        }
    }
}