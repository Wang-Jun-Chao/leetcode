/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-03 18:46
 **/
public class Solution {
    /**
     * <pre>
     * Given an array of numbers nums, in which exactly two elements appear only
     * once and all the other elements appear exactly twice. Find the two elements that appear only once.
     *
     * Example:
     *
     * Input:  [1,2,1,3,2,5]
     * Output: [3,5]
     * Note:
     *
     * The order of the result is not important. So in the above example, [5, 3] is also correct.
     * Your algorithm should run in linear runtime complexity. Could you implement it using
     * only constant space complexity?
     * </pre>
     *
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }

        int temp = xor;
        int count = 0;
        while ((1 & (temp % 2)) != 1) {
            count++;
            temp >>>= 1;
        }

        int x = 0;
        int y = 0;

        for (int i : nums) {
            if (((i >> count) & 1) == 1) {
                x ^= i;
            } else {
                y ^= i;
            }
        }

        return new int[]{x, y};
    }
}
