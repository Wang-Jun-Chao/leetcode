/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 16:55
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Given a sorted array of integers, find the starting and ending position of a given target value.
     * Your algorithm’s runtime complexity must be in the order of O(log n).
     * If the target is not found in the array, return [-1, -1].
     * For example,
     * Given [5, 7, 7, 8, 8, 10] and target value 8,
     * return [3, 4].
     *
     * 题目大意
     * 给定一个排好序的数组，同时给定一个要查找的值 ，找出这个数在数组中的出现在起始和结束位置。
     * 算法的时间复杂度要求为log(N)。
     * 如果没有找到就返回[-1, -1]
     *
     * 解题思路
     * 假定数组是递增有序的）先用二分查找算法看数组中是否存在这个数，如果不存在就返回[-1,-1]
     * 如果存在就分别找这个数最后一次出来现的位置和最开始出现的位置。找最后出现的位置时，先从数
     * 组最后一个位置开始找，如果大于待找的值，就前近一个位置，还大于就前近2个，以2找指数数增加，
     * 如果小于就退回到原来位置的后一个进行查找，重新按1，2，4、、、这样子的方式进行，直到找到为止。
     * 对于找最先的元素也是一样的。
     * </pre>
     *
     * @param A
     * @param target
     * @return
     */
    public int[] searchRange(int[] A, int target) {

        if (A == null || A.length == 0) {
            return new int[]{-1, -1};
        }

        int lo = 0;
        int hi = A.length - 1;
        int mi = 0;
        // 查找数组中是否存在值为target的元素
        while (lo <= hi) {
            mi = lo + (hi - lo) / 2;
            if (target < A[mi]) {
                hi = mi - 1;
            } else if (target > A[mi]) {
                lo = mi + 1;
            } else {
                break;
            }

        }

        if (A[mi] != target) {
            return new int[]{-1, -1};
        }

        lo = searchFirst(A, 0, mi, target);
        hi = searchLast(A, mi, A.length - 1, target);

        return new int[]{lo, hi};
    }

    /**
     * 找target最先出现的位置，查找的范围是[lo, hi]，A[hi]等于target，A为有序数组
     *
     * @param A      待查找的数组
     * @param lo     查找的起始位置
     * @param hi     查找的结束位置
     * @param target 查找的值
     * @return target最先出现的位置
     */
    private int searchFirst(int[] A, int lo, int hi, int target) {

        int gap = 1;
        do {
            hi -= gap;
            if (hi < lo || A[hi] != target) {
                hi += gap;

                if (hi <= lo || A[hi - 1] != target) {
                    return hi;
                } else {
                    gap = 1;
                    hi--;
                }
            } else {// 在上一次的位置后退gap个依然相等
                gap *= 2;
            }
        } while (true);

    }

    /**
     * 找target最后出现的位置，查找的范围是[lo, hi]，A[lo]等于target，A为有序数组
     *
     * @param A      待查找的数组
     * @param lo     查找的起始位置
     * @param hi     查找的结束位置
     * @param target 查找的值
     * @return target最后出现的位置
     */
    private int searchLast(int[] A, int lo, int hi, int target) {
        int gap = 1;
        do {
            lo += gap;
            if (lo > hi || A[lo] != target) {
                lo -= gap;

                if (lo >= hi || A[lo + 1] != target) {
                    return lo;
                } else {
                    gap = 1;
                    lo++;
                }
            } else {// 在上一次的位置前进gap个依然相等
                gap *= 2;
            }
        } while (true);
    }
}
