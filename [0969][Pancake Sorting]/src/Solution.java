import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pancake-sorting/
 *
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-09 18:29
 **/
public class Solution {
    /**
     * <pre>
     * Given an array A, we can perform a pancake flip: We choose some positive integer
     * k <= A.length, then reverse the order of the first k elements of A.  We want to
     * perform zero or more pancake flips (doing them one after another in succession)
     * to sort the array A.
     *
     * Return the k-values corresponding to a sequence of pancake flips that sort A.
     * Any valid answer that sorts the array within 10 * A.length flips will be judged
     * as correct.
     *
     *
     *
     * Example 1:
     *
     * Input: [3,2,4,1]
     * Output: [4,2,4,3]
     * Explanation:
     * We perform 4 pancake flips, with k values 4, 2, 4, and 3.
     * Starting state: A = [3, 2, 4, 1]
     * After 1st flip (k=4): A = [1, 4, 2, 3]
     * After 2nd flip (k=2): A = [4, 1, 2, 3]
     * After 3rd flip (k=4): A = [3, 2, 1, 4]
     * After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted.
     * Example 2:
     *
     * Input: [1,2,3]
     * Output: []
     * Explanation: The input is already sorted, so there is no need to flip anything.
     * Note that other answers, such as [3, 3], would also be accepted.
     *
     * 思路：
     * （1）找到当前序列的最大值；
     * （2）翻到序列的首位置；
     * （3）翻到当前序列最后的位置；
     * 完成把当前最大值放到最后的操作，即完成选择排序的选择最大值到最后的操作。
     * 缩减未排序的序列，即可完成排序；
     * </pre>
     *
     * @param nums nums元素的值是[1, 2, ..., nums.length]的一个排列
     * @return
     */
    public List<Integer> pancakeSort(int[] nums) {
        List<Integer> result = new ArrayList<>();

        if (nums != null && nums.length > 1) {
            for (int i = nums.length - 1; i >= 0; i--) {
                int pos = 0;
                while (pos <= i) {
                    if (nums[pos] == i + 1) {
                        break;
                    }
                    pos++;
                }

                // pos == i说明i位置的元素已经排好了
                if (pos < i) {
                    reverse(nums, 0, pos);
                    reverse(nums, 0, i);
                    result.add(pos + 1);
                    result.add(i + 1);
                }

            }
        }

        return result;
    }

    private void reverse(int[] arr, int x, int y) {
        while (x < y) {
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
            x++;
            y--;
        }
    }
}
