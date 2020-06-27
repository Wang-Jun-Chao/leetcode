import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-07 11:35
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        int[][] arr = {{1, 0}};
        Assert.assertEquals(true, solution.canFinish(2, arr));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int[][] arr = {{1, 0}, {0, 1}};
        Assert.assertEquals(false, solution.canFinish(2, arr));
    }


    @Test
    public void test3() {
        Solution solution = new Solution();
        int[][] arr = {{0, 1}, {0, 2}, {1, 2}};
        Assert.assertEquals(true, solution.canFinish(3, arr));
    }

    @Test
    public void test4() {
        Solution solution = new Solution();
        int[][] arr = {{2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}};
        Assert.assertEquals(false, solution.canFinish(4, arr));
    }


    @Test
    public void test5() {
        Solution solution = new Solution();
        int[][] arr = {{1, 0}, {2, 6}, {1, 7}, {6, 4}, {7, 0}, {0, 5}};
        Assert.assertEquals(true, solution.canFinish(8, arr));
    }
}
