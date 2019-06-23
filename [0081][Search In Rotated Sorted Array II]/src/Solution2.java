/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-13 06:19
 **/
public class Solution2 {
    /**
     * 分析
     * 允许重复元素，则上一题中如果A[mid]>=A[left], 那么[left,mid] 为递增序列的假设就不能成立了，比
     * 如[1,3,1,1,1]。
     * 如果A[mid]>=A[left] 不能确定递增，那就把它拆分成两个条件：
     * • 若A[mid]>A[left]，则区间[left,mid] 一定递增
     * • 若A[mid]==A[left] 确定不了，那就l++，往下看一步即可。
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return false;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }

            // [left, mid]区间递增
            if (nums[left] < nums[mid]) {
                // target在[nums[left], nums[mid]]之间
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) { // [mid, right]区间递增
                // target在[nums[mid], nums[right]]之间
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // 无法区分递增区间，向右移动一个位置
                left++;
            }
        }


        return false;
    }
}
