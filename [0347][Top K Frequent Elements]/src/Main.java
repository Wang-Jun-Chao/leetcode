import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-03 21:13
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        System.out.println(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        System.out.println(solution.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2));
    }
}
