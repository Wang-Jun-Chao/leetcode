/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-11-16 15:43
 **/
public class Solution {

    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
    }


    public boolean isPowerOfFour3(int num) {
        int n = 0b1010101_01010101_01010101_01010101;
//        int n = 0x55555555;
        return num > 0 && (num & (num - 1)) == 0 && (num & n) == num;
    }

    public boolean isPowerOfFour2(int num) {
        double rst = (Math.log10(num) / Math.log10(4));
        return num > 0 && Double.doubleToLongBits((int) rst) == Double.doubleToLongBits(rst);
    }

    public boolean isPowerOfFour1(int num) {
        while (num > 1 && (num % 4 == 0)) {
            num /= 4;
        }
        return num == 1;
    }
}
