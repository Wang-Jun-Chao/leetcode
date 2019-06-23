import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-09-28 15:15
 **/
public class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(list, new LinkedList<>(), nums, target, 0);
        return list;

    }

    /**
     * @param list     结果集
     * @param tempList 临时结果集
     * @param nums     可选值数组
     * @param remain   剩余值
     * @param start    可选值的起始下标
     */
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            list.add(new LinkedList<>(tempList));
        } else {
            for (int i = start; i < nums.length; i++) {
                // 如果上一轮循环没有选nums[i]，则本次循环就不能再选nums[i]，
                // 确保nums[i] 最多只用一次
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                tempList.add(nums[i]);
                // 数值不可以被重用
                backtrack(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
