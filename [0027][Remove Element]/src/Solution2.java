/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 16:43
 * Declaration: All Rights Reserved !!!
 */
public class Solution2 {
    /**
     * <pre>
     * 原题
     * Given an array and a value, remove all instances of that value in place and return the new length.
     *  The order of elements can be changed. It doesn’t matter what you leave beyond the new length.
     *
     * 题目大意
     * 给定一个数组和一个值，删除数组中与这个值相等的元素，并且返回与这个数组的新的长度。
     *
     * 解题思路
     *
     * </pre>
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {

        // [0, ..., index - 1]表示已经排除val的值的子数组，index表示之后可以放置元素的位置，
        // 也表示子类组的长度
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            // 不相等就移动
            if (nums[i] != val) {
                nums[index] = nums[i];
                ++index;
            }
        }

        return index;
    }
}
