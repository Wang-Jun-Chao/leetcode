import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-09-28 15:11
 **/
public class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // 用于保存结果
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    // 回溯法
    // list:保存总的结果
    // tempList:保存临时结果
    // nums:输入的数组
    // remain:剩下的值
    // start:可用的值在数组中的起始位置
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        // 不够减
        if (remain < 0) {
            return;
        } else if (remain == 0) { // 刚好够减
            list.add(new LinkedList<>(tempList));
        } else {
            // 从剩下的数中一个一个尝试
            for (int i = start; i < nums.length; i++) {
                // 假设这个值是临时结果中的一个值
                tempList.add(nums[i]);
                // 处理下一步
                backtrack(list, tempList, nums, remain - nums[i], i);
                // 现场还原
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
