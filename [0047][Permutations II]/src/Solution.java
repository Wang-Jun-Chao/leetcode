import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-09-28 15:29
 **/
public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }

        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);

        permuteUnique(nums, used, list, res);
        return res;
    }

    /**
     * 时间复杂度：n!
     *
     * @param nums
     * @param used
     * @param list
     * @param res
     */
    private void permuteUnique(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 第i个数值已经被使用过
            if (used[i]) {
                continue;
            }

            // 第i个字符与前一个字符相等，并且第i-1个字符没有使用，说明此次不应该交换
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }

            // 标记第i个字符已经被使用
            used[i] = true;
            // 添加到临时结果中
            list.add(nums[i]);
            // 下一次处理
            permuteUnique(nums, used, list, res);
            // 现场还原
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
