/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-16 11:27
 **/
public class Solution {
    /**
     * <pre>
     * There are N children standing in a line. Each child is assigned a rating value.
     *
     * You are giving candies to these children subjected to the following requirements:
     *
     * 1. Each child must have at least one candy.
     * 2. Children with a higher rating get more candies than their neighbors.
     * What is the minimum candies you must give?
     *
     * Example 1:
     *
     * Input: [1,0,2]
     * Output: 5
     * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
     * Example 2:
     *
     * Input: [1,2,2]
     * Output: 4
     * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
     *              The third child gets 1 candy because it satisfies the above two conditions.
     * </pre>
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length < 1) {
            return 0;
        }


        int[] increment = new int[ratings.length];
        // 左右各扫描一遍
        for (int i = 1, inc = 1; i < ratings.length; i++) {
            // 右边的孩子分数比左边的孩子分数高
            if (ratings[i] > ratings[i - 1]) {
                // 右边的孩子比左边的孩子多发至少一个糖果
                increment[i] = increment[i - 1] + 1;
            }
//            // 右边的孩子分数与左边的孩子分数相等，相等可以少发
//            else if (ratings[i] == ratings[i - 1]) {
//                // 右边和左边的孩子增同样多颗糖
//                increment[i] = increment[i - 1];
//            }
            // 可以不处理
//            else{
//                increment[i] = 0;
//            }
        }

        // 从右到左进行处理
        for (int i = ratings.length - 2, inc = 1; i >= 0; i--) {
            // 左边的孩子分数比右边高
            if (ratings[i] > ratings[i + 1]) {
                increment[i] = Math.max(increment[i], increment[i + 1] + 1);
            }
            //
//            else if (ratings[i] == ratings[i + 1]) {
//                // 总是成立了
//                increment[i] = increment[i - 1];
//            }
            // ratings[i] < ratings[i + 1] 不需要操作
        }

        int sum = ratings.length;
        for (int n : increment) {
            sum += n;
        }
        return sum;
    }
}
