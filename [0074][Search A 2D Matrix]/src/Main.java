import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-19 16:11
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();

        int[][] matrix = {{1, 3}};
        Assert.assertEquals(true, solution.searchMatrix(matrix, 3));
    }
}
