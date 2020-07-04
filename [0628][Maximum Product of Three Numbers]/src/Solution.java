import java.util.Arrays;

/**
 * Author: 王俊超
 * Time: 2020-07-04 20:23
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);

        int len = nums.length;

        int max = nums[len - 1] * nums[len - 2] * nums[len - 3];

        if (nums[1] < 0) { // 前两个是负数
            max = Math.max(max, nums[0]*nums[1]*nums[len-1]);
        }


        return max;
    }
}
