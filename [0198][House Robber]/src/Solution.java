/**
 * Author: 王俊超
 * Date: 2015-06-17
 * Time: 22:00
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * You are a professional robber planning to rob houses along a street. Each house has a
     * certain amount of money stashed, the only constraint stopping you from robbing each
     * of them is that adjacent houses have security system connected and it will automatically
     * contact the police if two adjacent houses were broken into on the same night.
     * <p>
     * Given a list of non-negative integers representing the amount of money of each house,
     * determine the maximum amount of money you can rob tonight without alerting the police.
     * <p>
     * 题目大意：你是一名专业强盗，计划沿着一条街打家劫舍。每间房屋都储存有一定数量的金钱，唯一能阻止你
     * 打劫的约束条件就是：由于房屋之间有安全系统相连，如果同一个晚上有两间相邻的房屋被闯入，它们就会自
     * 动联络警察，因此不可以打劫相邻的房屋。
     * <p>
     * 给定一列非负整数，代表每间房屋的金钱数，计算出在不惊动警察的前提下一晚上最多可以打劫到的金钱数。
     * 解题思路：动态规划（Dynamic Programming）
     * 状态转移方程：dp[i] = max(dp[i - 2], dp[i - 3]) + num[i] 【A】
     * 其中，dp[i]表示打劫到第i间房屋时累计取得的金钱最大值。
     * (第 i 个位置的 max 值是由 max(i-2, i-3) 加上 i 位置的值决定，以此类推)
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 如果数组中的元素个个数大于2个，对于【A】式，i=2，dp[2-3]不存在
        if (nums.length > 2) {
            nums[2] += nums[0];
        }

        // 从第四个元素开始处理
        int i = 3;
        for (; i < nums.length; i++) {
            // 求出第i个元素的最大值
            nums[i] += Math.max(nums[i - 2], nums[i - 3]);
        }

        // 如果只有一个元素，返回这个元素值
        if (nums.length == 1) {
            return nums[0];
        }
        // 有两个元素返回其中较大的值
        else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 多于两个元素，最大值在末尾两个之间，找最大的返回
        else {
            return Math.max(nums[i - 1], nums[i - 2]);
        }
    }
}
