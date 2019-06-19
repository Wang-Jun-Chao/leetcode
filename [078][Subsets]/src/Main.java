import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-19 16:27
 **/
public class Main {
    @Test
    public void test1() {
        int[] nums = {1, 2, 3};

        Solution solution = new Solution();

        System.out.println(solution.subsets(nums));
    }
}
