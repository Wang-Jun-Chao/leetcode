/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-09-28 15:18
 **/
public class Solution {
    /**
     * <pre>
     * Given an unsorted integer array, find the smallest missing positive integer.
     *
     * Example 1:
     *
     * Input: [1,2,0]
     * Output: 3
     * Example 2:
     *
     * Input: [3,4,-1,1]
     * Output: 2
     * Example 3:
     *
     * Input: [7,8,9,11,12]
     * Output: 1
     *
     * 本质上是桶排序(bucket sort)，每当A[i]!= i+1 的时候，将A[i] 与A[A[i]-1] 交换，
     * 直到无法交换为止，终止条件是A[i]== A[A[i]-1]。
     * </pre>
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // nums[i] == nums[nums[i] - 1] 说明出现了两个同样的元素或者两个是同一个元素
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
