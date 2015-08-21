/**
 * Author: 王俊超
 * Date: 2015-06-21
 * Time: 20:35
 * Declaration: All Rights Reserved !!!
 */
public class Solution {

    /**
     * <pre>
     * Given an array of integers, every element appears three times except for one.
     * Find that single one.
     *
     * Note:
     *   - Your algorithm should have a linear runtime complexity.
     *          Could you implement it without using extra memory?
     * 题目大意：
     * 给一个数组，里面只有一个数字一次，其它数字都出现3次，找出这个出现一次的数字，
     * 要求时间复杂度为O(n)，空间复杂度为O(1)。最好不傅额外的空间
     *
     * 解题思路
     * 方法一：考虑全部用二进制表示，如果我们把 第 i th   个位置上所有数字的和对3取余，
     * 那么只会有两个结果 0 或 1 (根据题意，3个0或3个1相加余数都为0).  因此取余的结
     * 果就是那个 “Single Number”。一个直接的实现就是用大小为 32的数组来记录所有
     * 位上的和。
     *
     * 方法二：使用掩码变量：
     * ones    代表第ith位只出现一次的掩码变量
     * twos    代表第ith位只出现两次次的掩码变量
     * threes  代表第ith位只出现三次的掩码变量
     * 当第ith位出现3次时，我们就ones和twos的第ith位设置为0. 最终的答案就是 ones。
     * </pre>
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {

        int[] count = new int[32];
        int result = 0;

        for (int i = 0; i < 32; i++) {
            for (int n : nums) {
                // 统计第i位的1的个数
                if (((n >> i) & 1) == 1) {
                    count[i]++;
                }
            }

            result |= (count[i] % 3) << i;
        }

        return result;
    }

    // TODO 未完全理解
    public int singleNumber2(int[] nums) {
        // 只出现一次的掩码变量，
        int ones = 0;
        // 只出现两次次的掩码变量
        int twos = 0;
        // 只出现三次的掩码变量
        int threes;

        for (int n : nums) {
            twos |= ones & n;
            // 异或3次 和 异或 1次的结果是一样的
            ones ^= n;
            // 对于ones和twos把出现了3次的位置设置为0（取反之后1的位置为0）
            threes = ones & twos;

            ones &= ~threes;
            twos &= ~threes;
        }

        return ones;
    }
}
