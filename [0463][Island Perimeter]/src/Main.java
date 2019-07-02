import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-02 13:07
 **/
public class Main {
    @Test
    public void test1() {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};
        Solution solution = new Solution();
        Assert.assertEquals(16, solution.islandPerimeter(grid));
    }

    @Test
    public void test2() {
        int[][] grid = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}};
        Solution solution = new Solution();
        Assert.assertEquals(16, solution.islandPerimeter(grid));
    }
}
