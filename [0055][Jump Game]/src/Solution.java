/**
 * Author: 王俊超
 * Date: 2015-06-19
 * Time: 19:29
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given an array of non-negative integers, you are initially positioned at the
     * first index of the array.
     *
     * Each element in the array represents your maximum jump length at that position.
     *
     * Determine if you are able to reach the last index.
     *
     * For example:
     * A = [2,3,1,1,4], return true.
     * A = [3,2,1,0,4], return false.
     *
     * 题目大意：
     * 给定的非负整数的数组，则最初定位在数组的第一个位置。数组中的每个元素都代表你的最大跳跃长度在那个位置。
     * 决定你是否能到达最后一个索引。
     *
     * </pre>
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        return canJump2(nums);
    }

    public boolean canJump1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }

        // 最后可以移动的位置
        int lastPos = 0;

        // 处理每一个位置
        for (int i = 0; i < nums.length; i++) {
            // i不能比lastPos大，否则说明不能走到i，走不到i也就不能走到最后
            // 如果在i位置可以移动的距离比已经记录到的最大距离还要大，那么更新最大的移动距离
            if (i <= lastPos && i + nums[i] > lastPos) {
                lastPos = i + nums[i];
            } else if (i > lastPos) {
                return false;
            }
        }

        // 最后的位置必然可以达到最后
        return lastPos >= nums.length - 1;
    }

    /**
     * 逆向，从最高层下楼梯，一层一层下降，看最后能不能下降到第0 层。
     *
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
