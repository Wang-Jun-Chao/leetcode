import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 19:39
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    private List<List<Integer>> result;
    private List<Integer> l;

    /**
     * <pre>
     * 原题
     * Given two integers n and k, return all possible combinations of k numbers out of 1 … n.
     * For example,
     * If n = 4 and k = 2, a solution is:
     *
     * [
     *  [2,4],
     *  [3,4],
     *  [2,3],
     *  [1,2],
     *  [1,3],
     *  [1,4],
     * ]
     *
     * 题目大意
     * 给定两个数n和k，求从1-n中k个数的所有组合。
     *
     * 解题思路
     * 采用递归分治法进行求解，详见代码。
     * </pre>
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        result = new LinkedList<>();

        if (n > 0 && k > 0 && n >= k) {
            l = new LinkedList<>();
            combine(1, n, k);
        }

        return result;
    }

    /**
     * 求组合
     *
     * @param start 可选择的数开始位置
     * @param end   可选择的数的结束位置
     * @param num   在[start, end]中选择的数的数目
     */
    private void combine(int start, int end, int num) {

        if (num == 0) {
            List<Integer> tmp = new ArrayList<>();
            for (Integer i : l) {
                tmp.add(i);
            }

            result.add(tmp);
            return;
        }

        int endFirst = end - num + 1; // 第一个数可以选择的最大值
        for (int i = start; i <= endFirst; i++) {
            l.add(i);
            combine(i + 1, end, num - 1);
            l.remove(new Integer(i));
        }
    }
}
