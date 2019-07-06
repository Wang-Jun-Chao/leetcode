/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-06 19:16
 **/
public class Solution {
    /**
     * <pre>
     * Given a binary array, find the maximum number of consecutive 1s in this array.
     *
     * Example 1:
     * Input: [1,1,0,1,1,1]
     * Output: 3
     * Explanation: The first two digits or the last three digits are consecutive 1s.
     *     The maximum number of consecutive 1s is 3.
     * Note:
     *
     * The input array will only contain 0 and 1.
     * The length of input array is a positive integer and will not exceed 10,000
     * </pre>
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {

        int result = 0;
        int start = 0;
        int end;
        while (start < nums.length) {
            while (start < nums.length && nums[start] != 1) {
                start++;
            }

            end = start + 1;
            while (end < nums.length && nums[end] == 1) {
                end++;
            }

            if (start < nums.length) {
                result = Math.max(result, end - start);
            }
            start = end;
        }

        return result;
    }
}
