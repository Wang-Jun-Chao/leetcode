/**
 * Author: 王俊超
 * Date: 2015-06-19
 * Time: 20:52
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Find the contiguous subarray within an array (containing at least one number)
     * which has the largest product.
     *
     * For example, given the array [2,3,-2,4],
     *
     * the contiguous subarray [2,3] has the largest product = 6.
     *
     * 题目大意：
     * 从数组（至少包含一个数字）中找出一个连续的子数组，该子数组的乘积最大。
     *
     * 解题思路：
     * 简单动态规划，
     *
     * 递推公式
     * 对于Product Subarray，要考虑到一种特殊情况，即负数和负数相乘：
     * 如果前面得到一个较小的负数，和后面一个较大的负数相乘，得到的反而是一个较大的数，如{2，-3，-7}，
     * 所以，我们在处理乘法的时候，除了需要维护一个局部最大值，同时还要维护一个局部最小值
     *
     * n<1说明输入有错，n大于0时
     * Fmax(0)=num[0]
     * Fmin(0)=num[0]
     *
     * Fmax(n+1) = MAX(MAX(num[n+1]*Fmax(n), num[n+1]), num[n+1]*Fmin(n)) // 最大值
     * Fmin(n+1) = MIN(MIN(num[n+1]*Fmax(n), num[n+1]), num[n+1]*Fmin(n)) // 最小值，为下一个新计算做准备
     * </pre>
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {

        if (nums == null || nums.length < 1) {
            throw new IllegalArgumentException();
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int result = nums[0];
        int fmax = nums[0];
        int fmin = nums[0];
        int prevMax;

        for (int i = 1; i < nums.length; i++) {
            prevMax = fmax;
            fmax = Math.max(Math.max(nums[i] * prevMax, nums[i]), nums[i] * fmin);
            fmin = Math.min(Math.min(nums[i] * prevMax, nums[i]), nums[i] * fmin);
            result = Math.max(result, fmax);
        }

        return result;
    }
}
