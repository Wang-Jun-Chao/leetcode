/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 16:40
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Given a sorted array, remove the duplicates in place such that each element
     * appear only once and return the new length.
     * Do not allocate extra space for another array, you must do this in place
     * with constant memory.
     * For example,
     * Given input array nums = [1,1,2],
     * Your function should return length = 2, with the first two elements of nums
     * being 1 and 2 respectively. It doesn’t matter what you leave beyond the new length.
     *
     * 题目大意
     * 给定一个排序的数组，将数组中的重复元素去掉，相同的只保留一个，并且返回数组新的元素个数，
     * 不要创建一个新的数组来保存结果。在常量时间内解决这个问题
     *
     * 解题思路
     * 从第二个元素开始处理，记为当前处理的元素，如果当前元素与他的前一个元素相同就删除这个元素，
     * 如果不同就将它移动到正确的位置，返回最后数组元素人个数。
     * </pre>
     *
     * @param A
     * @return
     */
    public int removeDuplicates(int[] A) {

        if (A.length == 0) {
            return 0;
        }

        int index = 0;//[0,index]只记录数组中出现的按从小到大的唯一一个数，已经排好序了
        int next = 1;

        // 算法思想：找index之后的比A[index]大的数，如是找到就移动到A[index+1]处，
        // index移动到下一个位置，next移动到下一个位置，再找比A[index]大的数

        while (next < A.length) {
            while (next < A.length && A[index] == A[next]) { // 找不等于数组中最
                next++;
            }

            if (next < A.length) {
                index++;
                A[index] = A[next];
                next++;
            }
        }
        return index + 1;
    }
}
