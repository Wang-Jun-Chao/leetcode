import java.util.Arrays;

/**
 * Author: 王俊超
 * Time: 2020-07-04 19:24
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);


        int diffStart = 0; // 从开始找第一个位置变化的下标
        while (diffStart < nums.length && nums[diffStart] == sorted[diffStart]) {
            diffStart++;
        }

        if (diffStart >= nums.length) {
            return 0;
        }


        int diffEnd = nums.length - 1; // 从最后找第一个位置变化的下标
        while (diffEnd >= 0 && nums[diffEnd] == sorted[diffEnd]) {
            diffEnd--;
        }



        return diffEnd - diffStart + 1;
    }
}
