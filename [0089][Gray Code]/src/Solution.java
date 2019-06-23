import java.util.LinkedList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015-06-22
 * Time: 13:16
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * The nums[c] is a binary numeral system where two successive values differ in only one bit.
     * Given a non-negative integer n representing the total number of bits in the code, print the
     * sequence of gray code. A gray code sequence must begin with 0.
     *
     * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
     * 00 - 0
     * 01 - 1
     * 11 - 3
     * 10 - 2
     *
     * Note:
     *   - For a given n, a gray code sequence is not uniquely defined.
     *   - For example, [0,2,3,1] is also a valid gray code sequence according to the above
     *          definition.
     *   - For now, the judge is able to judge based on one instance of gray code sequence.
     *          Sorry about that.
     *
     * 题目大意：
     * 给定n，输出长度为n的格雷码表
     *
     * 格雷码(Gray Code) 的定义请参考http://en.wikipedia.org/wiki/Gray_code。
     * 自然二进制码转换为格雷码：g0 = b0; gi = bi^b(i-1)
     * 保留自然二进制码的最高位作为格雷码的最高位，格雷码次高位为二进制码的高位与次高位异
     * 或，其余各位与次高位的求法类似。例如，将自然二进制码1001，转换为格雷码的过程是：保留最
     * 高位；然后将第1 位的1 和第2 位的0 异或，得到1，作为格雷码的第2 位；将第2 位的0 和第3 位
     * 的0 异或，得到0，作为格雷码的第3 位；将第3 位的0 和第4 位的1 异或，得到1，作为格雷码的
     * 第4 位，最终，格雷码为1101。
     * 格雷码转换为自然二进制码：b0 = g0; bi = gi^b(i-1)
     * 保留格雷码的最高位作为自然二进制码的最高位，次高位为自然二进制高位与格雷码次高位异
     * 或，其余各位与次高位的求法类似。例如，将格雷码1000 转换为自然二进制码的过程是：保留最高
     * 位1，作为自然二进制码的最高位；然后将自然二进制码的第1 位1 和格雷码的第2 位0 异或，得
     * 到1，作为自然二进制码的第2 位；将自然二进制码的第2 位1 和格雷码的第3 位0 异或，得到1，
     * 作为自然二进制码的第3 位；将自然二进制码的第3 位1 和格雷码的第4 位0 异或，得到1，作为
     * 自然二进制码的第4 位，最终，自然二进制码为1111。
     * 格雷码有数学公式，整数n 的格雷码是n^(n/2)。
     * 这题要求生成n 比特的所有格雷码。
     * 方法1，最简单的方法，利用数学公式，对从0 ~2^n-1 的所有整数，转化为格雷码。
     * 方法2，n比特的格雷码，可以递归地从n - 1 比特的格雷码生成。如
     *
     * 解题思路：
     * 递归生成码表
     *  这种方法基于格雷码是反射码的事实，利用递归的如下规则来构造：
     *  1位格雷码有两个码字
     *  (n+1)位格雷码中的前2^n个码字等于n位格雷码的码字，按顺序书写，加前缀0
     *  (n+1)位格雷码中的后2^n个码字等于n位格雷码的码字，按逆序书写，加前缀1
     * </pre>
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        if (n >= 0) {
            // 格雷码的前半部分
            result.add(0);
            // 格雷码最高位的值（非0时）
            int t = 1;
            // 每一次外循环求出的是位数i+1位的格雷码表，其相当于长度为i+1位的格雷码表的前半部分
            for (int i = 0; i < n; i++) {
                // 求出的长度为i+1位格雷码表的后半部分，前半部分由长度为i位的格雷码表给出
                for (int j = result.size() - 1; j >= 0; j--) {
                    result.add(result.get(j) ^ t);
                }
                // 最高位右移
                t <<= 1;
            }
        }
        return result;
    }
}
