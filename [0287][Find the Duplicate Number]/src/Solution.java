/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-03 19:04
 **/
public class Solution {
    /**
     * <pre>
     * Given an array nums containing n + 1 integers where each integer is between 1
     * and n (inclusive), prove that at least one duplicate number must exist. Assume
     * that there is only one duplicate number, find the duplicate one.
     *
     * Example 1:
     *
     * Input: [1,3,4,2,2]
     * Output: 2
     * Example 2:
     *
     * Input: [3,1,3,4,2]
     * Output: 3
     * Note:
     *
     * You must not modify the array (assume the array is read only).
     * You must use only constant, O(1) extra space.
     * Your runtime complexity should be less than O(n2).
     * There is only one duplicate number in the array, but it could be repeated more than once.
     * </pre>
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {

        for (int i = 1; i <= nums.length; i++) {
            // nums[i - 1] != i ; 当 num[8] = 9 的情况
            // nums[i - 1] != nums[nums[i - 1] - 1] ; 两个相同的数，位置被占用
            while (nums[i - 1] != i && nums[i - 1] != nums[nums[i - 1] - 1]) {
                swap(nums, i - 1, nums[i - 1] - 1);
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] != i) {
                return nums[i - 1];
            }
        }

        return -1;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
