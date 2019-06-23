/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-10 17:04
 **/
public class Solution {
    public void moveZeroes(int[] nums) {

        if (nums == null || nums.length < 1) {
            return;
        }

        int idx = 0;
        // 找第一个0的位置
        while (idx < nums.length && nums[idx] != 0) {
            idx++;
        }

        // 数组的值都非0
        if (idx >= nums.length) {
            return;
        }

        int temp = idx + 1;

        while (temp < nums.length) {
            // 找temp开始第一个非0的位置
            while (temp < nums.length && nums[temp] == 0) {
                temp++;
            }

            // 找到非0值，移动到idx位置
            if (temp < nums.length) {
                nums[idx] = nums[temp];
                idx++;
                temp++;
            }
        }

        // 从[idx, nums.length-1]的长度都设置为0
        for (int i = idx; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
