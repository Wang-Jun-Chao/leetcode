import java.util.Arrays;

/**
 * Author: 王俊超
 * Time: 2020-06-30 08:52
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 0) {
            return 0;
        }

        int result = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1;i++) {

            for (int j = i + 1; j < nums.length && nums[j] - nums[i] <= k; j++) {
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                    j++;
                }

                if (nums[j] - nums[i] == k) {
                    result++;
                }
            }

            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }

        }

        return result;
    }
}
