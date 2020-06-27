import java.util.Arrays;

/**
 * https://leetcode.com/problems/heaters/
 *
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-10 08:58
 **/
public class Solution {
    /**
     * <pre>
     * Winter is coming! Your first job during the contest is to design a standard heater
     * with fixed warm radius to warm all the houses.
     *
     * Now, you are given positions of houses and heaters on a horizontal line, find out
     * minimum radius of heaters so that all houses could be covered by those heaters.
     *
     * So, your input will be the positions of houses and heaters seperately, and your
     * expected output will be the minimum radius standard of heaters.
     *
     * Note:
     *
     * Numbers of houses and heaters you are given are non-negative and will not exceed
     * 25000.
     * Positions of houses and heaters you are given are non-negative and will not exceed
     * 10^9.
     * As long as a house is in the heaters' warm radius range, it can be warmed.
     * All the heaters follow your radius standard and the warm radius will the same.
     *
     *
     * Example 1:
     *
     * Input: [1,2,3],[2]
     * Output: 1
     * Explanation: The only heater was placed in the position 2, and if we use the
     * radius 1 standard, then all the houses can be warmed.
     *
     *
     * Example 2:
     *
     * Input: [1,2,3,4],[1,4]
     * Output: 1
     * Explanation: The two heater was placed in the position 1 and 4. We need to use
     * radius 1 standard, then all the houses can be warmed.
     * </pre>
     */
    public int findRadius(int[] houses, int[] heaters) {
        if (houses == null || houses.length < 1 || heaters == null || heaters.length < 1) {
            return 0;
        }

        // 对houses和heaters位置进行排序
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int result = 0;
        int idx = 0;

        for (int h : houses) {
            // 找离house最近的heater位置
            // A----X------B =>  取A
            // A------X----B =>  取B
            // A-----X-----B =>  取B
            while (idx < heaters.length - 1 && heaters[idx] + heaters[idx + 1] <= h * 2) {
                idx++;
            }

            // 更新最小的结果
            // Math.abs(heaters[idx] - h) 表示h的最小加热半径
            result = Math.max(result, Math.abs(heaters[idx] - h));
        }

        return result;
    }
}
