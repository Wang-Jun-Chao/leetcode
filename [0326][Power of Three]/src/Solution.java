/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-11-16 15:21
 **/
public class Solution {

    public boolean isPowerOfThree(int n) {
        double rst = (Math.log10(n) / Math.log10(3));
        return n > 0 && Double.doubleToLongBits((int) rst) == Double.doubleToLongBits(rst);
    }

    public boolean isPowerOfThree2(int n) {
        return (n > 0 && 1162261467 % n == 0);
    }

    public boolean isPowerOfThree1(int n) {
        while (n > 1 && n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }


}
