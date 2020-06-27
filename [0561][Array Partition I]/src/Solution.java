import java.util.Arrays;

/**
 * https://leetcode.com/problems/array-partition-i/
 *
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-04 08:46
 **/
public class Solution {
    /**
     * <pre>
     * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
     * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n
     * as large as possible.
     *
     * Example 1:
     * Input: [1,4,3,2]
     *
     * Output: 4
     * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
     * Note:
     * n is a positive integer, which is in the range of [1, 10000].
     * All the integers in the array will be in the range of [-10000, 10000].
     *
     * 解题思路
     * 先将数据组排序，取偶数位置的数相加，即为结果
     * 证明略
     * </pre>
     *
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }

        return result;
    }
}
