/**
 * Author: 王俊超
 * Time: 2020-07-04 20:51
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() < 1) {
            return true;
        }

        int[] pos = {0, 0};
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'U':
                    pos[1]++;
                    break;
                case 'D':
                    pos[1]--;
                    break;
                case 'L':
                    pos[0]--;
                    break;
                case 'R':
                    pos[0]++;
                    break;
            }
        }

        return pos[0] == 0 && pos[1] == 0;
    }
}
