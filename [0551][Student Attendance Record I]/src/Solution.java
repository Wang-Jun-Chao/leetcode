/**
 * Author: 王俊超
 * Time: 2020-07-02 08:05
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    public boolean checkRecord(String s) {
        int a = 0;
        int l = 0;
        int preLIndex = -1;
        if (s != null) {
            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) {
                    case 'A':
                        a++;
                        break;
                    case 'L':
                        if (l < 3) { // 连续两个L后面步不用记录了
                            if (preLIndex == -1) { // 刚开始记录
                                preLIndex = i;
                                l = 1;
                            } else if (preLIndex + 1 == i) { // 当前和前一个都是L
                                l++;
                                preLIndex = i;
                            } else { // 前一个不是L，重新记数
                                preLIndex = i;
                                l = 1;
                            }
                        }
                        break;
                    default:
                        // do nothing
                }
            }
        }

        return a <= 1 && l < 3;
    }
}
