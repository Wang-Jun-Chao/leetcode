import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-19 16:43
 **/
public class Solution {

    /**
     * <pre>
     * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
     *
     * Note: The solution set must not contain duplicate subsets.
     *
     * Example:
     *
     * Input: [1,2,2]
     * Output:
     * [
     *   [2],
     *   [1],
     *   [1,2,2],
     *   [2,2],
     *   [1,2],
     *   []
     * ]
     * </pre>
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> curr = new LinkedList<>();
        if (nums != null) {
            // 对S进行排序处理
            Arrays.sort(nums);
            dfs(nums, 0, result, curr);
        }

        return result;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> result, List<Integer> curr) {


        // 添加到结果中，说明有一种新的结产生
        result.add(new LinkedList<>(curr));


        for (int j = index; j < nums.length; j++) {
            // 在当前可选择的范围内，相同的只能选择一次
            if (j > index && nums[j] == nums[j - 1]) {
                continue;
            }

            // 添加元素
            curr.add(nums[j]);
            dfs(nums, j + 1, result, curr);
            // 还原
            curr.remove((Integer) nums[j]);
        }
    }
}
