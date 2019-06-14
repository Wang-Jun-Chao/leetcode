/**
 * Author: 王俊超
 * Date: 2015-06-21
 * Time: 15:21
 * Declaration: All Rights Reserved !!!
 */
public class Solution {


    /**
     * <pre>
     * Follow up for "Find Minimum in Rotated Sorted Array":
     * What if duplicates are allowed?
     * Would this affect the run-time complexity? How and why?
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     *
     *
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * Find the minimum element.
     * The array may contain duplicates.
     *
     * 题目大意：
     * “查找旋转排序的数组最小值”的后续：允许重复元素，但是两个字数组依然局部有序。
     *
     * 解题思路：
     * 采用类二分搜索算法进行查找
     *
     * </pre>
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        // 参数校验
        if (nums == null || nums.length < 1) {
            throw new IllegalArgumentException();
        }

        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;

        // 可以排除数组全局有序的情况
        while (nums[lo] >= nums[hi]) {

            // 如果只有两个元素，返回后一个
            if (hi - lo == 1) {
                mid = hi;
                break;
            }

            mid = lo + ((hi - lo) >> 1);

            if (nums[mid] == nums[lo] && nums[mid] == nums[hi]) {
                // 只能采用顺序搜索方法，不能采用lo++，hi--的方式
                // 因为lo可能是前一个有序数组的最后一个
                // hi也可能是后一个有序数组的第一个
                return sequenceSearch(nums, lo, hi);
            }

            // 如果mid在前一个有序数组中
            if (nums[mid] >= nums[lo]) {
                lo = mid;
            }
            // 如果mid在后一个有序数组中
            else if (nums[mid] <= nums[hi]) {
                hi = mid;
            }

        }


        return nums[mid];
    }

    /**
     * 顺序搜索数组中的最小值，nums是由有序数组按某个轴旋转得来的
     *
     * @param nums  搜索数组
     * @param start 开始位置
     * @param end   结束位置
     * @return 最小值
     */
    public int sequenceSearch(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[start];
    }
}
