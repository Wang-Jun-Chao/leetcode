import java.util.Arrays;

/**
 * https://leetcode.com/problems/assign-cookies/
 *
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-10 08:30
 **/
public class Solution {
    /**
     * <pre>
     * Assume you are an awesome parent and want to give your children some cookies.
     * But, you should give each child at most one cookie. Each child i has a greed
     * factor gi, which is the minimum size of a cookie that the child will be content
     * with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j
     * to the child i, and the child i will be content. Your goal is to maximize the
     * number of your content children and output the maximum number.
     *
     * Note:
     * You may assume the greed factor is always positive.
     * You cannot assign more than one cookie to one child.
     *
     * Example 1:
     * Input: [1,2,3], [1,1]
     *
     * Output: 1
     *
     * Explanation: You have 3 children and 2 cookies. The greed factors of 3 children
     * are 1, 2, 3.
     * And even though you have 2 cookies, since their size is both 1, you could only
     * make the child whose greed factor is 1 content.
     * You need to output 1.
     * Example 2:
     * Input: [1,2], [1,2,3]
     *
     * Output: 2
     *
     * Explanation: You have 2 children and 3 cookies. The greed factors of 2 children
     * are 1, 2.
     * You have 3 cookies and their sizes are big enough to gratify all of the children,
     * You need to output 2.
     * 思路：
     * 先将饼干尺寸和小孩需求都排个序，然后从小到大去遍历地给。
     * </pre>
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || g.length < 1 || s == null || s.length < 1) {
            return 0;
        }

        int result = 0;

        // 先对两个数组进行排序
        Arrays.sort(g);
        Arrays.sort(s);

        int gIdx = 0;
        int sIdx = 0;

        while (gIdx < g.length && sIdx < s.length) {
            while (sIdx < s.length && g[gIdx] > s[sIdx]) {
                sIdx++;
            }

            // 说明对于gIdx的贪婪值，sIdx可以满足
            if (sIdx < s.length) {
                result++;
            }

            // 如下一一个小孩的贪婪值
            gIdx++;
            // 下一个饼干的位置
            sIdx++;
        }

        return result;
    }
}
