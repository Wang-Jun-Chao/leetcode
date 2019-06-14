/**
 * 使用贪心算法，每次都移动最远的距离
 *
 * @author: wangjunchao(王俊超)
 * @time: 2018-09-28 15:27
 **/
public class Solution {

    public int jump(int[] nums) {

        if (nums == null || nums.length < 2) {
            return 0;
        }

        // 记录跳跃次数
        int jump = 0;
        // 记录当前可以到达的最远的位置
        int currentMax = 0;
        // 下一次可以到达的最远的位置
        int nextMax = 0;
        // 记录处理的位置
        int i = 0;

        // 还没有到最未位置，还可以移动
        while (currentMax - i + 1 > 0) {
            // 跳数增加
            jump++;
            // 找下一次最远可以移动的位置
            for (; i <= currentMax; i++) {
                nextMax = Math.max(nextMax, nums[i] + i);
                // 如果下一次可以移动到最末的位置，则返回跳数
                if (nextMax >= nums.length - 1) {
                    return jump;
                }
            }

            // 本次处理不能使移动位增加，并且不能到达最末位置，说明永远到不了最后的位置
            if (currentMax == nextMax) {
                return Integer.MAX_VALUE;
            }

            // 更新当前可以移动的最远位置
            currentMax = nextMax;
        }

        return 0;
    }

}
