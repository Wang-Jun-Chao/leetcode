import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-12 08:53
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        solution.duplicateZeros(arr);
        Assert.assertArrayEquals(new int[]{1, 0, 0, 2, 3, 0, 0, 4}, arr);
    }
}
