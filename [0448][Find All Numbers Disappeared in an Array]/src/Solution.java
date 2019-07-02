import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-02 08:29
 **/
public class Solution {
    /**
     * <pre>
     * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear
     * twice and others appear once.
     *
     * Find all the elements of [1, n] inclusive that do not appear in this array.
     *
     * Could you do it without extra space and in O(n) runtime? You may assume the returned list
     * does not count as extra space.
     *
     * Example:
     *
     * Input:
     * [4,3,2,7,8,2,3,1]
     *
     * Output:
     * [5,6]
     * </pre>
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {

        // i表示第几个元素，从1开始计数
        for (int i = 1; i <= nums.length; i++) {
            // nums[idx - 1]  != idx 对于nums[8]  = 9的情况
            // nums[idx - 1] == nums[nums[idx - 1] - 1]  位置被占用了，表示有相同的数
            while (nums[i - 1] != i && nums[i - 1] != nums[nums[i - 1] - 1]) {
                swap(nums, i - 1, nums[i - 1] - 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] != i) {
                result.add(i);
            }
        }

        return result;
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
