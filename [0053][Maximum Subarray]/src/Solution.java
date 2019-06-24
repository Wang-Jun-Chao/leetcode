/**
 * Author: 王俊超
 * Date: 2015-06-22
 * Time: 12:05
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given an integer array nums, find the contiguous subarray (containing at least one number)
     * which has the largest sum and return its sum.
     *
     * Example:
     *
     * Input: [-2,1,-3,4,-1,2,1,-5,4],
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     * Follow up:
     *
     * If you have figured out the O(n) solution, try coding another solution using the divide and
     * conquer approach, which is more subtle.
     *
     * 题目大意：
     * 求数组的最大子数组的和
     * 解题思路：
     * 动态规划问题，已知了前k个元素的最大子序列和为maxSub（已经被记录下来了），以及一个临时和sum，
     * 如果添加了第k+1这个元素，由于是连续子序列这个限制，所以如果k+1这个元素之前的和是小于0的，
     * 那么对于增大k+1这个元素从而去组成最大子序列是没有贡献的，所以可以把sum 置0。
     *
     * 当我们从头到尾遍历这个数组的时候，对于数组里的一个整数，它有几种选择呢？它只有两种
     * 选择：1、加入之前的SubArray；2. 自己另起一个SubArray。那什么时候会出现这两种情况呢？
     * 如果之前SubArray 的总体和大于0 的话，我们认为其对后续结果是有贡献的。这种情况下我们
     * 选择加入之前的SubArray
     * 如果之前SubArray 的总体和为0 或者小于0 的话，我们认为其对后续结果是没有贡献，甚至是
     * 有害的（小于0 时）。这种情况下我们选择以这个数字开始，另起一个SubArray。
     * 设状态为f[j]，表示以S[j] 结尾的最大连续子序列和，则状态转移方程如下：
     * f[j] = max {f[j - 1] + S[j]; S[j]} ; 其中1 <= j <= n
     * target = max {f[j]}; 其中1 <= j <= n
     * 解释如下：
     * 情况一，S[j] 不独立，与前面的某些数组成一个连续子序列，则最大连续子序列和为f[j - 1] + S[j]。
     * 情况二，S[j] 独立划分成为一段，即连续子序列仅包含一个数S[j]，则最大连续子序列和为S[j]。
     *
     * </pre>
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        // 参数校验
        if (nums == null || nums.length < 1) {
            throw new IllegalArgumentException();
        }

        int max = Integer.MIN_VALUE;
        int curSum = 0;

        for (int i : nums) {
            // 当前和小于0，就将当前值赋给curSum
            if (curSum <= 0) {
                curSum = i;
            }
            // 否则进行累加
            else {
                curSum += i;
            }

            // 保存较大的值
            if (max < curSum) {
                max = curSum;
            }
        }

        return max;
    }
}
