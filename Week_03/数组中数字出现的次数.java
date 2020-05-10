/*
* 考虑如果数组中只有一个数字落单，其他都成对的情况
* 一个数字异或它自己等于0，沿着数组异或过去，就只剩那个落单的数字了
* 目前有两个数字落单，其他成对
* 
* https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
*/
public class 数组中数字出现的次数 {
    class Solution {
        public int[] singleNumbers(int[] nums) {
            if (nums == null || nums.length < 2)
                return nums;
            int resultXOR = 0;
            for (int i = 0; i < nums.length; i++) {
                resultXOR ^= nums[i];
            }
            int indexOfOne = findFirstBitIsOne(resultXOR);
            int num1 = 0, num2 = 0;
            for (int j = 0; j < nums.length; j++) {
                if (isBitOne(nums[j], indexOfOne)) {
                    num1 ^= nums[j];
                } else {
                    num2 ^= nums[j];
                }
            }
            return new int[] { num1, num2 };
        }

        private int findFirstBitIsOne(int num) {
            int indexBit = 0;
            while ((num & 1) == 0) {
                num = num >> 1;
                indexBit++;
            }
            return indexBit;
        }

        private boolean isBitOne(int num, int indexBit) {
            num = num >> indexBit;
            return (num & 1) == 1;
        }
    }
}