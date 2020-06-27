/**
 * Author: ������
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
     * You may assume k is always valid, 1 �� k �� array's length.
     *
     * ��Ŀ���⣺
     * ��һ��δ��������������ҳ���k���Ԫ�ء�ע��������֮��ĵ�k�󣬶��ǵ�k�����ظ���Ԫ��
     * ���Լ���kһ������Ч�ģ� 1 �� k �� ���鳤��
     *
     * ����˼·��
     * O(n)�ⷨ������ѡ��QuickSelect���㷨
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

        // ����ֵ
        int pivot = nums[start];
        int lo = start;
        int hi = end;

        while (lo < hi) {
            // ��С������ֵ�����ƶ����������
            while (lo < hi && nums[hi] >= pivot) {
                hi--;
            }
            nums[lo] = nums[hi];

            // ����������ֵ�����ƶ��������ұ�
            while (lo < hi && nums[lo] <= pivot) {
                lo++;
            }
            nums[hi] = nums[lo];
        }

        nums[lo] = pivot;

        // ����Ѿ��ҵ���
        if (end - lo + 1 == k) {
            return pivot;
        }
        // ��k�������loλ�õ��ұ�
        else if (end - lo + 1 > k) {
            return findKthLargest(nums, lo + 1, end, k);
        }
        // ��k�������loλ�õ����
        else {
            // k-(end-lo+1)
            // (end-lo+1)����ʾ��loλ�ÿ�ʼ��endλ�õ�Ԫ�ظ�������������Ұ벿��
            // ԭ���ĵ�k����k-(end-lo+1)��
            return findKthLargest(nums, start, lo - 1, k - (end - lo + 1));
        }
    }
}
