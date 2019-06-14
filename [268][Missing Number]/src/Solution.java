/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-10 14:02
 **/
public class Solution {
    public int missingNumber(int[] nums) {

        if (nums == null || nums.length < 1) {
            throw new IllegalArgumentException("array should contain at least one element");
        }

        for (int i = 0; i < nums.length; i++) {
            // 只会存在一个大于nums.length的数，将其放在数组最后一个位置
            if (nums[i] > nums.length) {
                swap(nums, i, nums.length - 1);
            }

            // 交换位置，直到nums[i] = i
            while (nums[i] != i && nums[i] < nums.length) {
                swap(nums, i, nums[i]);
            }
        }

        // 找出丢失的元素
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
