/**
 * Author: 王俊超
 * Date: 2015-06-17
 * Time: 20:54
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     * Find the median of the two sorted arrays. The overall run time complexity
     * should be O(log (m+n)).
     *
     * 题目大意：
     * 两个排序数组，找这两个排序数组的中位数，时间复杂度为O(log(m+n))
     *
     * 题解思路：
     * 递归分治求解
     * </pre>
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 != 0) {
            return findKth(nums1, 0, nums2, 0, total / 2 + 1);
        } else {
            return (findKth(nums1, 0, nums2, 0, total / 2)
                    + findKth(nums1, 0, nums2, 0, total / 2 + 1)
            ) / 2.0;
        }
    }

    /**
     * 在数组两个数组中找第k大的元素，k=1, 2, 3, ...
     *
     * @param nums1  数组1
     * @param start1 起始位置1
     * @param nums2  数组2
     * @param start2 起始位置2
     * @param k      要找的中位位置
     * @return
     */
    public int findKth(int[] nums1, final int start1,
                       int[] nums2, final int start2,
                       final int k) {
        // 将要查找长度小的放在前面
        if (nums1.length - start1 > nums2.length - start2) {
            return findKth(nums2, start2, nums1, start1, k);
        }

        // 较少元素的数组已经达到末尾
        if (nums1.length == start1) {
            return nums2[start2 + k - 1];
        }

        // 第一个，就找两个中比较小的
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }


        // 在num1, nums2数组中各找一半的数，相当于每次丢掉要查总数的1/4
        int half = Math.min(k / 2, nums1.length - start1);
        // nums2数组中可找的位置
        int ia = half + start1;
        // nums2数组中可找的位置
        int ib = k - half + start2;

        // nums1[start, ..., ia-1, ia, ..., nums1.length]
        // nums2[start, ..., ib-1, ib, ..., nums2.length]
        // 说明子数组nums1[start, ..., ia-1]可以弃了，要找的值在nums1[ia, ..., nums1.length]
        // 和nums2[start, ..., ib-1, ib, ..., nums2.length]中
        if (nums1[ia - 1] < nums2[ib - 1]) {
            // k - (ia - start1) = k - (half + start1 - start1) = k - half
            return findKth(nums1, ia, nums2, start2, k - (ia - start1));
        }

        // 说明子数组nums2[start, ..., ib-1]可以弃了，要找的值在nums2[ib, ..., nums2.length]
        // nums1[start, ..., ia-1, ia, ..., nums1.length]
        else if (nums1[ia - 1] > nums2[ib - 1]) {
            // k - (ib - start2) = k - (k - half + start2 - start2)
            return findKth(nums1, start1, nums2, ib, half);
        }
        // 两个值相等说明找到了，
        else {
            return nums1[ia - 1];
        }
    }
}
