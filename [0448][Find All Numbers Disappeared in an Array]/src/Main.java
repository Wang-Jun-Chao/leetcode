import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-02 08:38
 **/
public class Main {
    @Test
    public void test1() {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        Solution solution = new Solution();
        System.out.println(solution.findDisappearedNumbers(arr));
    }
}
