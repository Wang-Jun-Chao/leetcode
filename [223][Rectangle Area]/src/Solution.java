import java.util.*;

/**
 * Author: 王俊超
 * Date: 2015-06-19
 * Time: 15:32
 * Declaration: All Rights Reserved !!!
 */
public class Solution {

    /**
     * <pre>
     * Find the total area covered by two rectilinear rectangles in a 2D plane.
     * Each rectangle is defined by its bottom left corner and top right
     * corner as shown in the figure.
     *
     * Assume that the total area is never beyond the maximum possible value of int.
     *
     * *****************************(C,D):(3,4)
     * *                           *
     * *                           *
     * *           *************************************(G,H):(9,2)
     * *           *               *                   *
     * *           *               *                   *
     * *           *               *                   *
     * *           *               *                   *
     * *           *(0,0)          *                   *
     * *****************************                   *
     * (A,B):(-3,0)*                                   *
     *             *                                   *
     *             * (E,F):(0，-1)                     *
     *             *************************************
     *
     *   ***************************        ***************************
     *   *            D            *        *            H            *
     *   *                         *        *                         *
     *   *A                       C*        *E                       G*
     *   *                         *        *                         *
     *   *                         *        *                         *
     *   *            B            *        *            F            *
     *   ***************************        ***************************
     *
     *
     *
     * </pre>
     * 题目大意：
     * 计算两个矩形总共覆盖的面积
     * <p>
     * 解题思路：
     * 计算方法为矩形1的面积+矩形2的面积-两个矩形共同的覆盖面积。
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @param E
     * @param F
     * @param G
     * @param H
     * @return
     */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long area = (long) (C - A) * (D - B) + (long)(G - E) * (H - F);
        // Math.min(C, G) 表示右边边的最小的边
        // Math.max(A, E) 表示左边边的最大的边
        // 下面的减法会产生数组越介，要扩大数据范围
        long width = Math.max((long)Math.min(C, G) - (long)Math.max(A, E), 0);
        // Math.min(D, H) 表示顶边边的最小的边
        // Math.max(B, F) 表示底边边的最大的边
        long height = Math.max((long)Math.min(D, H) - (long)Math.max(B, F), 0);

        System.out.println(width +":" + height + "=" + width*height);

        return (int)(area - width * height);
    }


}
