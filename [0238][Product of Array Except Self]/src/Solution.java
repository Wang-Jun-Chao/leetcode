import java.util.HashSet;
import java.util.Set;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-30 14:29
 **/
public class Solution {
    /**
     * <pre>
     * Given an array nums of n integers where n > 1,
     * return an array output such that output[i] is equal to the product of all the
     * elements of nums except nums[i].
     *
     * Example:
     *
     * Input:  [1,2,3,4]
     * Output: [24,12,8,6]
     * Note: Please solve it without division and in O(n).
     *
     * Follow up:
     * Could you solve it with constant space complexity? (The output array does not count as
     * extra space for the purpose of space complexity analysis.)
     * </pre>
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        // 记录为0的下票
        Set<Integer> zero = new HashSet<>();


        long product = 1;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            if (nums[i] == 0) {
                zero.add(i);
            }
        }

        // 0的个数大于1个
        if (zero.size() > 1) {
            return result;
        } else if (zero.size() == 1) {
            int firstZeroIndex = 0;
            for (Integer i : zero) {
                firstZeroIndex = i;
            }

            result[firstZeroIndex] = 1;
            for (int i = 0; i < nums.length; i++) {
                if (i != firstZeroIndex) {
                    result[firstZeroIndex] *= nums[i];
                }
            }

            return result;
        } else {
            // 没有0
            for (int i = 0; i < nums.length; i++) {
                result[i] = (int) (product / nums[i]);
            }

            return result;
        }

    }
}
