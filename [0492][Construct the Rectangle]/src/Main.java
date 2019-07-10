import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-10 10:02
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        Assert.assertArrayEquals(new int[]{2, 2}, solution.constructRectangle(4));
    }
}
