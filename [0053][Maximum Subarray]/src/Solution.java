/**
 * Author: 王俊超
 * Date: 2015-06-22
 * Time: 12:05
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     *<pre>
     * Find the contiguous subarray within an array (containing at least one number)
     * which has the largest sum.
     *
     * For example, given the array [?2,1,?3,4,?1,2,1,?5,4],
     * the contiguous subarray [4,?1,2,1] has the largest sum = 6.
     *
     * 题目大意：
     * 求数组的最大子数组的和
     * 解题思路：
     * 动态规划问题，已知了前k个元素的最大子序列和为maxSub（已经被记录下来了），以及一个临时和sum，
     * 如果添加了第k+1这个元素，由于是连续子序列这个限制，所以如果k+1这个元素之前的和是小于0的，
     * 那么对于增大k+1这个元素从而去组成最大子序列是没有贡献的，所以可以把sum 置0。
     *</pre>
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
            if (curSum <= 0){
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
