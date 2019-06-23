/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-14 21:17
 **/
public class Solution {
    /**
     * <pre>
     * Implement next permutation, which rearranges numbers into the lexicographically next
     * greater permutation of numbers.
     *
     * If such arrangement is not possible, it must rearrange it as the lowest possible order
     * (ie, sorted in ascending order).
     *
     * The replacement must be in-place and use only constant extra memory.
     *
     * Here are some examples. Inputs are in the left-hand column and its corresponding outputs
     * are in the right-hand column.
     *
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     *
     * 1.首先从最尾端开始往前寻找一个元素，满足nums[i] < nums[i+1]。
     * 如果没有找到即i < 0, 说明整个数组是递增的，已经到了最大值，此时只要反转数组即可
     * 如果i >= 0
     *
     * 2.再从最尾端开始往前检验，找出第一个大于nums[i]的元素nums[j] 并且，j >= i
     * 将nums[i],nums[j]元素对调(swap)。
     *
     * 3.再将i位置之后的所有元素颠倒(reverse)排序。
     * </pre>
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 从后向前查找第一个元素i，并且使用nums[i] >= nums[i+1]不成立。
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 此时nums[i+1, ..., last]是递增的


        if (i >= 0) {
            int j = nums.length - 1;
            // 从右开始向左找，找第一个大于等num[i]的元素
            // 如果找到i==j，说明没有找到
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }

            // 交换两者之间的值，当j == i时，交换也没有问题
            swap(nums, i, j);

            // 将nums[i+1, last]进行反转
            reverse(nums, i + 1);
        } else {
            // 说明整个序列是非递增的
            // 对子数组进行翻转
            reverse(nums, 0);
        }


    }

    private void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
