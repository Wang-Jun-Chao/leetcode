import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015-06-20
 * Time: 21:46
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
     * Find all unique triplets in the array which gives the sum of zero.
     *
     * Note:
     * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
     * The solution set must not contain duplicate triplets.
     *
     * For example, given array S = {-1 0 1 2 -1 -4},
     * A solution set is:
     * (-1, 0, 1)
     * (-1, -1, 2)
     *
     * 题目大意：
     * 给定一个n个元素的数组，是否存在a，b，c三个元素，使用得a+b+c=0，找出所有符合这个条件的三元组
     *
     * 注意：
     *   - 三元组中的元素必须是非递减的
     *   - 结果不能包含重复元素
     *
     * 解题思路：
     * 可以在 2sum问题 的基础上来解决3sum问题，假设3sum问题的目标是target。每次从数组中选出一个数k，
     * 从剩下的数中求目标等于target-k的2sum问题。这里需要注意的是有个小的trick：当我们从数组中选出
     * 第i数时，我们只需要求数值中从第i+1个到最后一个范围内字数组的2sum问题。
     *
     * 我们以选第一个和第二个举例，假设数组为A[],总共有n个元素A1，A2....An。很显然，当选出A1时，
     * 我们在子数组[A2~An]中求目标位target-A1的2sum问题，我们要证明的是当选出A2时，我们只需要在
     * 子数组[A3~An]中计算目标位target-A2的2sum问题，而不是在子数组[A1,A3~An]中，证明如下：
     * 假设在子数组[A1,A3~An]目标位target-A2的2sum问题中，存在A1 + m = target-A2（m为A3~An中
     * 的某个数），即A2 + m = target-A1，这刚好是“对于子数组[A3~An],目标位target-A1的2sum问题”
     * 的一个解。即我们相当于对满足3sum的三个数A1+A2+m = target重复计算了。因此为了避免重复计算，
     * 在子数组[A1，A3~An]中，可以把A1去掉，再来计算目标是target-A2的2sum问题。
     *
     * 对于本题要求的求最接近解，只需要保存当前解以及当前解和目标的距离，如果新的解更接近，则更新解。
     * 算法复杂度为O（n^2）;
     * </pre>
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();

        if (nums != null && nums.length > 2) {
            // 先对数组进行排序
            Arrays.sort(nums);
            // i表示假设取第i个数作为结果
            for (int i = 0; i < nums.length - 2; ) {
                // 第二个数可能的起始位置
                int j = i + 1;
                // 第三个数可能是结束位置
                int k = nums.length - 1;

                while (j < k) {
                    // 如果找到满足条件的解
                    if (nums[j] + nums[k] == -nums[i]) {
                        // 将结果添加到结果含集中
                        List<Integer> list = new ArrayList<>(3);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);

                        // 移动到下一个位置，找下一组解
                        k--;
                        j++;

                        // 从左向右找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        // 从右向左找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    }
                    // 和大于0
                    else if (nums[j] + nums[k] > -nums[i]) {
                        k--;
                        // 从右向左找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    }
                    // 和小于0
                    else {
                        j++;
                        // 从左向右找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                    }
                }

                // 指向下一个要处理的数
                i++;
                // 从左向右找第一个与之前处理的数不同的数的下标
                while (i < nums.length - 2 && nums[i] == nums[i - 1]) {
                    i++;
                }
            }
        }

        return result;
    }
}
