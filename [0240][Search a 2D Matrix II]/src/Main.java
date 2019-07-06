import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-06 20:12
 **/
public class Main {
    @Test
    public void test1() {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        Solution solution = new Solution();

        Assert.assertEquals(true, solution.searchMatrix(matrix, 5));
        Assert.assertEquals(false, solution.searchMatrix(matrix, 20));
    }
}
