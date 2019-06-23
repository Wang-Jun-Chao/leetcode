import java.util.Collections;

/**
 * Author: 王俊超
 * Date: 2015-06-19
 * Time: 19:36
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Find the kth largest element in an unsorted array. Note that it is the kth
     * largest element in the sorted order, not the kth distinct element.
     *
     * For example,
     * Given [3,2,1,5,6,4] and k = 2, return 5.
     *
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ array's length.
     *
     * 题目大意：
     * 从一个未经排序的数组中找出第k大的元素。注意是排序之后的第k大，而非第k个不重复的元素
     * 可以假设k一定是有效的， 1 ≤ k ≤ 数组长度
     *
     * 解题思路：
     * O(n)解法：快速选择（QuickSelect）算法
     * </pre>
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {

        if (k < 1 || nums == null || nums.length < k) {
            throw new IllegalArgumentException();
        }

        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    public int findKthLargest(int[] nums, int start, int end, int k) {

        // 中枢值
        int pivot = nums[start];
        int lo = start;
        int hi = end;

        while (lo < hi) {
            // 将小于中枢值的数移动到数组左边
            while (lo < hi && nums[hi] >= pivot) {
                hi--;
            }
            nums[lo] = nums[hi];

            // 将大于中枢值的数移动到数组右边
            while (lo < hi && nums[lo] <= pivot) {
                lo++;
            }
            nums[hi] = nums[lo];
        }

        nums[lo] = pivot;

        // 如果已经找到了
        if (end - lo + 1 == k) {
            return pivot;
        }
        // 第k大的数在lo位置的右边
        else if (end - lo + 1 > k){
            return findKthLargest(nums, lo + 1, end, k);
        }
        // 第k大的数在lo位置的左边
        else {
            // k-(end-lo+1)
            // (end-lo+1)：表示从lo位置开始到end位置的元素个数，就是舍掉右半部分
            // 原来的第k大变成k-(end-lo+1)大
            return findKthLargest(nums, start, lo - 1, k - (end - lo + 1));
        }
    }
}
