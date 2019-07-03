import org.junit.Test;

import java.util.Arrays;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-03 18:56
 **/
public class Main {
    @Test
    public void test1() {

        Solution solution = new Solution();
        int[] diff = solution.singleNumber(new int[]{1, 2, 1, 3, 2, 5});
        System.out.println(Arrays.toString(diff));
    }
}
