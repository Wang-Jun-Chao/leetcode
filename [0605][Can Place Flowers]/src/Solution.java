/**
 * Author: 王俊超
 * Time: 2020-07-04 19:42
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length < 1) {
            return false;
        }

        if (n < 1) {
            return true;
        }

        // 找第一个1的位置
        int firstOneIdx = 0;
        while (firstOneIdx < flowerbed.length && flowerbed[firstOneIdx] == 0) {
            firstOneIdx++;
        }

        // [0,0,0] => 2
        // [0,0] => 1
        // [0] => 0
        int num = firstOneIdx / 2 + firstOneIdx % 2;

        if (firstOneIdx >= flowerbed.length) {
            return num >= n;
        } else {
            // [0,0,0,1] => 1
            // [0,0,1] => 1
            // [0,1] => 0
            num -= firstOneIdx % 2;
        }

        int prev = flowerbed[firstOneIdx];
        for (int i = firstOneIdx + 1; i < flowerbed.length; i++) {
            if (prev == 0 && flowerbed[i] == 0) {
                // i是最后一个，或者下一个位置也没有种花
                if (i + 1 >= flowerbed.length || flowerbed[i + 1] == 0) {
                    num++;
                    flowerbed[i] = 1;
                }
            }

            prev = flowerbed[i];
        }


        return num >= n;
    }
}
