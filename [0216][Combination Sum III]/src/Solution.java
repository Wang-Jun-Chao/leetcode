import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015-06-21
 * Time: 21:31
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Find all possible combinations of k numbers that add up to a number n,
     * given that only numbers from 1 to 9 can be used and each combination
     * should be a unique set of numbers.
     *
     * Ensure that numbers within the set are sorted in ascending order.
     *
     * Example 1:
     * Input: k = 3, n = 7
     * Output:
     * [[1,2,4]]
     *
     * Example 2:
     * Input: k = 3, n = 9
     * Output:
     * [[1,2,6], [1,3,5], [2,3,4]]
     *
     * 题目大意：
     * 寻找所有满足k个数之和等于n的组合，只允许使用数字1-9，并且每一种组合中的数字应该是唯一的。
     * 确保组合中的数字以递增顺序排列。
     *
     * 解题思路：
     * 回溯法
     * </pre>
     *
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        // 用于保存所有结果
        List<List<Integer>> result = new LinkedList<>();
        // 用于保存中间结果
        List<Integer> list = new LinkedList<>();
        // 条件满足就进行解题操作
        if (k > 0 && k <= 9) {
                solve(k, 1, n, 0, list, result);
        }

        // 返回结果
        return result;
    }

    /**
     * 求解方法
     *
     * @param k         每个解的元素个数
     * @param cur       当前处理第k个元素
     * @param remainder k - cur + 1个元素的和
     * @param prevVal   第cur-1个元素的取值
     * @param list      将解的元素的集合类
     * @param result    保存所有结果的容器
     */
    public void solve(int k, int cur, int remainder, int prevVal, List<Integer> list, List<List<Integer>> result) {
        // 处理最后一个元素
        if (cur == k) {
            // remainder为最后一个解元素的值，它必须大于前一个解元素的值，并且不能超出9
            if (remainder > prevVal && remainder <= 9) {
                // 添加元素值
                list.add(remainder);

                // 拷贝结果到新的队列中
                List<Integer> one = new LinkedList<>();
                for (Integer i : list) {
                    one.add(i);
                }

                // 保存结果
                result.add(one);
                // 删除最后一个元素，进行现场还原
                list.remove(list.size() - 1);
            }
        }
        // 不是最后一个元素
        else if (cur < k){
            for (int i = prevVal + 1; i <= 9 - (k - cur); i++) {
                // 添加元素
                list.add(i);
                // 递归求解
                solve(k, cur + 1, remainder - i, i, list, result);
                // 现场还原
                list.remove(list.size() - 1);

            }
        }


    }
}
