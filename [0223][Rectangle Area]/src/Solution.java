/**
 * Author: ������
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
     *             * (E,F):(0��-1)                     *
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
     * ��Ŀ���⣺
     * �������������ܹ����ǵ����
     * <p>
     * ����˼·��
     * ���㷽��Ϊ����1�����+����2�����-�������ι�ͬ�ĸ��������
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
        long area = (long) (C - A) * (D - B) + (long) (G - E) * (H - F);
        // Math.min(C, G) ��ʾ�ұ߱ߵ���С�ı�
        // Math.max(A, E) ��ʾ��߱ߵ����ı�
        // ����ļ������������Խ�飬Ҫ�������ݷ�Χ
        long width = Math.max((long) Math.min(C, G) - (long) Math.max(A, E), 0);
        // Math.min(D, H) ��ʾ���߱ߵ���С�ı�
        // Math.max(B, F) ��ʾ�ױ߱ߵ����ı�
        long height = Math.max((long) Math.min(D, H) - (long) Math.max(B, F), 0);

        System.out.println(width + ":" + height + "=" + width * height);

        return (int) (area - width * height);
    }


}
