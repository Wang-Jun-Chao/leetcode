/**
 * Author: 王俊超
 * Date: 2015-06-19
 * Time: 20:12
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * Find the minimum element.
     * You may assume no duplicate exists in the array.
     *
     * 题目大意：
     * 假设一个排序的数组以事先未知的某个中枢进行了旋转。
     * （即，0 1 2 4 5 6 7可能成为4 5 6 7 0 1 2）。
     *
     * 找到最小的元素。
     * 你可以假设不存在重复的数组中。
     *
     * 钥匙思路：
     * 二分搜索法，数组分为两个有序的部分，前一个部分和后一个部分并且前一个排序部分元素都比后一个元素大
     * 只要找到后一个元素比前一个大就是要找的元素
     * </pre>
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        // 参数检验
        if (nums == null || nums.length < 0) {
            throw new IllegalArgumentException();
        }

        return binarySearch(nums, 0, nums.length - 1);
    }

    public int binarySearch(int[] nums, int start, int end) {

        int mid = 0;

        while (start < end) {
            mid = start + ((end - start) >> 1);
//            System.out.println(mid + " " + nums[mid]);
            // 后一个数比前个数小就找到了
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            // 说明中间值在第一个有序的数组中
            else if (nums[mid] > nums[start]) {
                // 不取mid+1是有可能num[mid]是第一个有序数组中的最后一个元素
                start = mid;
            }
            // 说明中间值在第二个有序的数组中
            else {
                // 不取mid-1是有可能num[mid]是第二个有序数组中的第一个元素
                end = mid;
            }
        }

        // 说明整个数组是有序的
        return nums[0];
    }
}
