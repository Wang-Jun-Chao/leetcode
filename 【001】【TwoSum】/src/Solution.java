import java.util.Arrays;

/**
 * Author: 王俊超
 * Date: 2015-06-17
 * Time: 20:27
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    private static class Node implements Comparable<Node> {
        int val;
        int idx;

        public Node() {
        }

        public Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            if (o == null) {
                return -1;
            }
            return this.val - o.val;
        }
    }


    /**
     * <pre>
     * Given an array of integers, find two numbers such that they add up to a specific target number.
     * The function twoSum should return indices of the two numbers such that they add up to the target,
     * where index1 must be less than index2. Please note that your returned answers (both index1 and index2)
     * are not zero-based.
     * You may assume that each input would have exactly one solution.
     *
     * Input: numbers={2, 7, 11, 15}, target=9
     * Output: index1=1, index2=2
     *
     * 题目大意
     * 给定一个整数数组，找出其中两个数满足相加等于你指定的目标数字。
     * 要求：这个函数twoSum必须要返回能够相加等于目标数字的两个数的索引，且index1必须要小于index2。
     * 请注意一点，你返回的结果（包括index1和index2）都不是基于0开始的。你可以假设每一个输入肯定只有一个结果。
     *
     * 解题思路
     * 创建一个辅助类数组，对辅助类进行排序，使用两个指针，开始时分别指向数组的两端，看这两个下标对应的值是否
     * 等于目标值，如果等于就从辅助类中找出记录的下标，构造好返回结果，返回。如果大于就让右边的下标向左移，
     * 进入下一次匹配，如果小于就让左边的下标向右移动，进入下一次匹配，直到所有的数据都处理完
     * </pre>
     *
     * @param nums
     * @param target
     * @return
     */

    public int[] twoSum(int[] nums, int target) {
        int[] result = {0, 0};

        Node[] tmp = new Node[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = new Node(nums[i], i);
        }

        Arrays.sort(tmp);

        int lo = 0;
        int hi = nums.length - 1;


        while (lo < hi) {
            if (tmp[lo].val + tmp[hi].val == target) {

                if (tmp[lo].idx > tmp[hi].idx) {
                    result[0] = tmp[hi].idx + 1;
                    result[1] = tmp[lo].idx + 1;
                } else {
                    result[0] = tmp[lo].idx + 1;
                    result[1] = tmp[hi].idx + 1;
                }
                break;
            } else if (tmp[lo].val + tmp[hi].val > target) {
                hi--;
            } else {
                lo++;
            }
        }
        return result;
    }
}
