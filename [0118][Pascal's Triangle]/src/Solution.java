import java.util.ArrayList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 19:05
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Given numRows, generate the first numRows of Pascal’s triangle.
     * For example, given numRows = 5,
     * Return
     *
     * [
     * [1],
     * [1,1],
     * [1,2,1],
     * [1,3,3,1],
     * [1,4,6,4,1]
     * ]
     *
     * 题目大意
     * 给定一个正整数n，求n层帕斯卡三角形。
     *
     * 解题思路
     * 对任意的n>0有
     * f(1, n)=1，(n>0)
     * f(1, 2)=1，(n=2)
     * f(i,j) = f(i-1, j-1)+f(i, j-1)，i>2,j>2
     * </pre>
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {

        if (numRows < 0) {
            return null;
        }

        List<List<Integer>> list = new ArrayList<>();

        if (numRows >= 1) {
            List<Integer> data = new ArrayList<>();
            data.add(1);
            list.add(data);
        }

        if (numRows >= 2) {
            List<Integer> data = new ArrayList<>();
            data.add(1);
            data.add(1);
            list.add(data);
        }

        if (numRows >= 3) {
            for (int i = 3; i <= numRows; i++) {
                List<Integer> data = new ArrayList<>();
                List<Integer> prev = list.get(i - 2);
                data.add(1);
                for (int j = 2; j <= i - 1; j++) {
                    data.add(prev.get(j - 2) + prev.get(j - 1));
                }
                data.add(1);

                list.add(data);
            }
        }

        return list;
    }
}
