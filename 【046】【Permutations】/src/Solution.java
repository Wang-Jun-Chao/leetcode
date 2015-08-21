import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 16:50
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    private List<List<Integer>> result;

    /**
     * <pre>
     * 原题
     * Given a collection of numbers, return all possible permutations.
     * For example,
     * [1,2,3] have the following permutations:
     * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
     *
     * 题目大意
     * 给定一个数组，返回他的所有排列。
     *
     * 解题思路
     * 使用分治法求解。
     * </pre>
     *
     * @param num
     * @return
     */
    public List<List<Integer>> permute(int[] num) {

        result = new LinkedList<>();
        if (num != null) {
            permute(0, num);
        }

        return result;
    }

    private void permute(int i, int[] num) {

        if (i == num.length) {
            List<Integer> l = new ArrayList<>();
            for (int n : num) {
                l.add(n);
            }

            result.add(l);
        } else {

            for (int j = i; j < num.length; j++) {
                swap(num, j, i);
                permute(i + 1, num);
                swap(num, j, i);
            }
        }
    }

    private void swap(int[] A, int x, int y) {
        int tmp = A[x];
        A[x] = A[y];
        A[y] = tmp;
    }
}
