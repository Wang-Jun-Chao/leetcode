import java.util.HashSet;

/**
 * Author: ������
 * Date: 2015-06-17
 * Time: 21:36
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * Write an algorithm to determine if a number is "happy".
     * A happy number is a number defined by the following process: Starting with any positive integer,
     * replace the number by the sum of the squares of its digits, and repeat the process until the number
     * equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those
     * numbers for which this process ends in 1 are happy numbers.
     * <p>
     * ��ĿҪ�������һ�������������ϸ�����λ�����ֵ�ƽ���ͣ�����������Ϊ1���������Ϊhappy number��
     * ���������ܴ�ĳ������ʼ����ѭ����
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {

        if (n < 1) {
            return false;
        }

        // ���ڱ����м���ֵĽ��
        HashSet<Integer> set = new HashSet<>(32);

        int tmp;
        int newN;

        // n��Ϊ1������n��ֵ�����ظ����֣��������ѭ��
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            newN = 0;
            while (n > 0) {
                tmp = n % 10;
                n /= 10;
                newN += tmp * tmp;
            }

            n = newN;
        }

        return n == 1;
    }

}
