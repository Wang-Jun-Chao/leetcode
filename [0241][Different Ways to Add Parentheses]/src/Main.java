import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-06 20:59
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        System.out.println(solution.diffWaysToCompute("2-1-1"));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        System.out.println(solution.diffWaysToCompute("2*3-4*5"));
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        System.out.println(solution.diffWaysToCompute("2"));
    }
}
