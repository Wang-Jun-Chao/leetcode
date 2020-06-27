import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-11 13:49
 **/
public class Solution2 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        if (nums == null || nums.length < 1) {
            return result;
        }

        int idx = 1;

        while (idx <= nums.length) {
            // 如果nums[9-1] != 9 说明还没有调整到位置
            // nums[idx-1] == nums[nums[idx-1] - 1]说明有同样的值出现
            while (nums[idx - 1] != idx && nums[idx - 1] != nums[nums[idx - 1] - 1]) {
                swap(nums, idx - 1, nums[idx - 1] - 1);
            }

            idx++;
        }

        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] != i) {
                result.add(nums[i - 1]);
            }
        }

        Collections.sort(result);
        return result;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
