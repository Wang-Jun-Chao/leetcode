/**
 * Author: 王俊超
 * Time: 2020-07-05 16:23
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k < 1) {
            return 0;
        }

        double sum = 0;
        for (int i = 0; i < nums.length && i < k; i++) { // 求nums[0, k-1]的和
            sum += nums[i];
        }

        double max = sum;
        for (int j = k; j < nums.length; j++) { // 求nums[j-k,j]中的大值
            sum = sum + nums[j] - nums[j - k];
            max = Math.max(max, sum);

        }

        return max / k;
    }
}
