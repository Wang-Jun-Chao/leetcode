/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-09 09:13
 **/
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(prices) == 7);

        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println(solution.maxProfit(prices2) == 4);

        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println(solution.maxProfit(prices3) == 0);
    }
}
