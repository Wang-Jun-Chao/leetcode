/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 19:37
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Given an array with n objects colored red, white or blue, sort them so that objects
     * of the same color are adjacent, with the colors in the order red, white and blue.
     * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
     * and blue respectively.
     * Note:
     * You are not suppose to use the library’s sort function for this problem.
     *
     * 题目大意
     * 给定一个对象数组，对象是红色，白色和蓝色，对颜色进行排序，红，白，蓝。
     * 使用0，1，2分别代表红，白，蓝。
     * 注意：不能使用库函数进行排序。
     *
     * 解题思路
     * 对数组进行扫描，计录1的个数和整个数组的和。扫描完后可以得出1的数目t，2的数目(sum-t)/2，
     * 最后可以得出0的数目，这样子根据0，1，2的数目再对数组进行设置值。
     * </pre>
     *
     * @param A
     */
    public void sortColors(int[] A) {

        if (A == null) {
            return;
        }

        int count = 0; // 统计1的个数
        int sum = 0; // 统计数组的和

        for (int i : A) {
            if (i == 1) {
                count++;
            }

            sum += i;
        }

        sum = (sum - count) / 2; // 计算2的数目

        count = A.length - count - sum; // 1开始出现的位置

        sum = A.length - sum; // 2开始出现的位置

        for (int i = 0; i < count; i++) {
            A[i] = 0;
        }

        for (int i = count; i < sum; i++) {
            A[i] = 1;
        }

        for (int i = sum; i < A.length; i++) {
            A[i] = 2;
        }
    }
}
