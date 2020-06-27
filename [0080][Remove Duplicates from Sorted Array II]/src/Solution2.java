/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-12 22:53
 **/

/**
 * 删除重复出现的数字，使之最多出现两次
 */
public class Solution2 {
    public int removeDuplicates(int[] nums) {
        int i = 0;

        // 处理每一个数字
        for (int n : nums) {
            // i < 2 处理前两个数字
            // n > nums[i - 2]说明n不与nums[i - 2]重复，并且因为数组有序，那么必然n > nums[i - 2]
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }

        return i;
    }
}

