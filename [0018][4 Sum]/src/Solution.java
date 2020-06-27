import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 16:28
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Given an array S of n integers, are there elements a, b, c, and d in S
     * such that a + b + c + d = target? Find all unique quadruplets in the array
     * which gives the sum of target.
     * Note:
     * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
     * The solution set must not contain duplicate quadruplets.
     *
     * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
     *
     * A solution set is:
     * (-1,  0, 0, 1)
     * (-2, -1, 1, 2)
     * (-2,  0, 0, 2)
     *
     * 题目大意
     * 给定一个整数数组，找出a + b + c + d = target的唯一解。
     *
     * 解题思路
     * 先确定a和d的两个数，对于a和d两个数，不能同时重复使用。然后再确定b和c，同样这两个数也不能
     * 同时重复使用。找出所有满足条件的解，同时可以保证解不重复。
     * </pre>
     *
     * @param num
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if (num == null || num.length < 4) {
            return result;
        }

        // 对数组进行排序
        Arrays.sort(num);

        // 第一个加数
        for (int i = 0; i < num.length - 3; ) {
            // 第四个加数
            for (int j = num.length - 1; j > i + 2; j--) {
                // 第四个加数使用不重复
                if (j < num.length - 1 && num[j] == num[j + 1]) {
                    continue;
                }

                // 第二个加数
                int start = i + 1;
                // 第三个加数
                int end = j - 1;
                int n = target - num[i] - num[j];

                while (start < end) {
                    if (num[start] + num[end] == n) {
                        List<Integer> four = new ArrayList<>(4);
                        four.add(num[i]);
                        four.add(num[start]);
                        four.add(num[end]);
                        four.add(num[j]);

                        result.add(four);

                        do {
                            start++;
                            // 保证再次使用第二个数不重复
                        } while (start < end && num[start] == num[start - 1]);
                        do {
                            end--;
                            // 保证再次使用第三个数不重复
                        } while (start < end && num[end] == num[end + 1]);
                    } else if (num[start] + num[end] < n) {
                        do {
                            start++;
                            // 保证再次使用第二个数不重复
                        } while (start < end && num[start] == num[start - 1]);
                    } else {
                        do {
                            end--;
                            // 保证再次使用第三个数不重复
                        } while (start < end && num[end] == num[end + 1]);
                    }
                }
            }

            // 相同的数字作为处理只能使用一次
            do {
                i++;
            } while (i < num.length - 2 && num[i - 1] == num[i]);
        }
        return result;
    }
}
