/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 17:20
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     * Note:
     * You may assume that nums1 has enough space (size that is greater or equal to m + n) to
     * hold additional elements from nums2. The number of elements initialized in nums1 and
     * nums2 are m and n respectively.
     *
     * 题目大意
     * 给定两个排序的数组，将两个数组进行合并，合并后也是有序的，合并结果存放在nums1中。
     * nums1中有足够的空间容纳nums2。
     *
     * 解题思路
     * 从两个数组中的最后一个位置开始进行合并，先找两个数中较大的移动到正的位置，将那个移
     * 动的位置值向前移动一个位置，再进行同样的操作，直到所有的元素处理完。
     * </pre>
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int A[], int m, int B[], int n) {
        int pa = m - 1;
        int pb = n - 1;
        int index = m + n - 1;

        while (pa >= 0 && pb >= 0) {
            if (A[pa] >= B[pb]) {
                A[index--] = A[pa--];
            } else {
                A[index--] = B[pb--];
            }
        }

        while (pb >= 0) { // 说明pa一定为0
            A[index--] = B[pb--];
        }

        // 如果pa >= 0，说明[0, pa]还没有进行判断，因为[0, pa]的数在A中，所以不要移动了
    }
}
