/**
 * Author: 王俊超
 * Time: 2020-06-28 21:38
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    /**
     * 解题思路：
     * 假设数组最小的值是xmin，一共加了k次，加完后的值是W，元素个数是n
     * 则：W <= xmin + k
     * k(n-1) + sum(nums) = W*n
     * ==>
     * k(n-1) + sum(nums) <= (xmin + k)n
     * ==>
     * sum(nums) - n*xmin <= k
     *
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {

        if (nums == null) {
            return 0;
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i : nums) {
            sum += i;
            if (i < min) {
                min = i;
            }
        }

        return sum - min * nums.length;
    }
}
