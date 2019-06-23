import java.util.HashMap;
import java.util.Map;

/**
 * Author: 王俊超
 * Date: 2015-06-19
 * Time: 14:10
 * Declaration: All Rights Reserved !!!
 */
public class Solution {

    /**
     * Given an array of integers and an integer k, find out whether there there are
     * two distinct indices i and j in the array such that nums[i] = nums[j] and the
     * difference between i and j is at most k.
     * 
     * 题目大意：
     * 给定一个整数数组nums与一个整数k，当且仅当存在两个不同的下标i和j满足nums[i] = nums[j]
     * 并且|i-j|<=k时返回true，否则返回false。
     *
     * 解题思路：
     * 对nums[0...n-1]，存入一个map中，(muns[i], i)，如果键nums[k]已经存在，
     * 则比较之前的下标和现在的下标的差值，如果差值不大于k，说明到了满足条件的两个值，
     * 否则使用新的下标作为值
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 输入条件判断
        if (nums == null || nums.length < 2 || k < 1) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            // 如果没有对应的key添加进去
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
            // 已经有对应的key-value对
            else {
                // 原来保存的值对应的下标，它一定小于现在的下标
                int value = map.get(nums[i]);
                if (i - value <= k) {
                    return true;
                }
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
