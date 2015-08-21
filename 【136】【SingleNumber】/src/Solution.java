/**
 * Author: 王俊超
 * Date: 2015-06-18
 * Time: 10:29
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * Given an array of integers, every element appears twice except for one.
     * Find that single one.
     *
     * Note: Your algorithm should have a linear runtime complexity.
     * Could you implement it without using extra memory?
     *
     * 给定一个数组，每个元素都出现2次除了其中的一个，找出只出现一次的数字
     * 注意：算法必须是线性时间复杂度，可以不使用额外空间实现吗？
     *
     * 解题思路：使用异或运算
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {

        if (nums == null || nums.length < 1) {
            throw new IllegalArgumentException("nums");
        }


        for (int i = 1; i< nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}
