import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 19:41
 * Declaration: All Rights Reserved !!!
 */
public class Solution3 {

    /**
     * <pre>
     * 原题
     * Given a set of distinct integers, nums, return all possible subsets.
     * Note:
     * Elements in a subset must be in non-descending order.
     * The solution set must not contain duplicate subsets.
     * For example,
     * If nums = [1,2,3], a solution is:
     *
     * [
     *  [3],
     *  [1],
     *  [2],
     *  [1,2,3],
     *  [1,3],
     *  [2,3],
     *  [1,2],
     *  []
     * ]
     *
     * 题目大意
     * 给定一个不同数字的数组，返回它的所有子集。
     *
     * 解题思路
     * 先对数组中的元素进行排序，然后再用递归分治法进行求解。
     * </pre>
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> curr = new LinkedList<>();
        if (nums != null) {

            // 对S进行排序处理
            Arrays.sort(nums);
            // i表示子集元素个数
            for (int i = 0; i <= nums.length; i++) {
                subset(nums, 0, i, result, curr);
            }
        }

        return result;
    }

    /**
     * 找元素有n个的子集数
     *
     * @param nums   元素集合
     * @param idx    可取元素的起始位置
     * @param n      集合元素个数
     * @param result 结果集
     * @param curr   临时解
     */
    private void subset(int[] nums, int idx, int n, List<List<Integer>> result, List<Integer> curr) {

        // 已经处理到末尾了，说明有一个解
        if (n == 0) {
            result.add(new LinkedList<>(curr));
            return;
        }

        // 还没有处理完，递归处理下一个元素
        for (int i = idx; i < nums.length - n + 1; i++) {
            curr.add(nums[i]);
            subset(nums, i + 1, n - 1, result, curr);
            curr.remove((Integer) nums[i]);
        }
    }


}
