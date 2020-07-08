/**
 * Author: 王俊超
 * Time: 2020-07-07 10:03
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null) {
            return 0;
        } else if (nums.length < 2) {
            return nums.length;
        }

        int prev = 0;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            while (i < nums.length && nums[i - 1] < nums[i]) {
                i++;
            }

            max = Math.max(max, i - prev);
            prev = i;
        }

        return max;
    }
}
