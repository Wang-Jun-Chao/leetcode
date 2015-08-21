/**
 * Author: 王俊超
 * Date: 2015-06-21
 * Time: 14:46
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Follow up for "Search in Rotated Sorted Array":
     * What if duplicates are allowed?
     * Would this affect the run-time complexity? How and why?
     * Write a function to determine if a given target is in the array
     *
     * 题目大意：
     * "在旋转数组中搜索值"的后续，如果数组中的值允许重复
     * 写一个程序确定一个给定的值是否在数组中
     * </pre>
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        if (nums != null && nums.length > 0) {
            // 找最小元素对应的下标
            int minIndex = findMinIndex(nums);

            // 整个数组全局有序
            if (minIndex == 0) {
                return binarySearch(nums, 0, nums.length - 1, target);
            }
            // 有两个局部有序区间,  如 4 5 6 7 8 9 0 1 2 3
            else {
                // 恬好和后一个有序区间的最后一个元素相等，返回对应的下标
                if (nums[nums.length - 1] == target) {
                    return true;
                }
                // target可能在后一个有序区间中
                else if (nums[nums.length - 1] > target) {
                    return binarySearch(nums, minIndex, nums.length - 1, target);
                }
                // target可能是前一个有序区间中
                else {
                    return binarySearch(nums, 0, minIndex - 1, target);
                }
            }
        }

        return false;
    }

    /**
     * 二分搜索
     *
     * @param nums   数组
     * @param start  起始位置
     * @param end    结束位置
     * @param target 搜索目标
     * @return true找到，false没有找到
     */
    public boolean binarySearch(int[] nums, int start, int end, int target) {

        int mid;
        while (start <= end) {
            mid = start + ((end - start) >> 1);

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }


    public int findMinIndex(int[] nums) {
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
                return sequenceSearchMinIndex(nums, lo, hi);
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

        return mid;
    }

    /**
     * 顺序搜索数组中的最小值的下标，nums是由有序数组按某个轴旋转得来的
     *
     * @param nums  搜索数组
     * @param start 开始位置
     * @param end   结束位置
     * @return 最小值的下标
     */
    public int sequenceSearchMinIndex(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] > nums[i + 1]) {
                return i + 1;
            }
        }
        return start;
    }
}
