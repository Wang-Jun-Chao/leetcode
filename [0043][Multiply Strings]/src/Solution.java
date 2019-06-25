/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-09-28 15:23
 **/
public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        int mul;
        int index;
        int temp;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 求积
                mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 积的最低位所在的位置
                index = i + j + 1;

                // 最低低求和
                pos[index] += mul;

                // 做进位处理
                while (pos[index] > 9) {
                    temp = pos[index];
                    pos[index] = temp % 10;
                    --index;
                    pos[index] += temp / 10;
                }

            }
        }


        StringBuilder sb = new StringBuilder();

        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
