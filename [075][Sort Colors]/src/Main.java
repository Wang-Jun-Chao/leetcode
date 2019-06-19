import org.junit.Test;

import java.util.Arrays;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-19 14:52
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] colors = {2, 0, 2, 1, 1, 0};
        solution.sortColors(colors);
        System.out.println(Arrays.toString(colors));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int[] colors = {2, 0, 1};
        solution.sortColors(colors);
        System.out.println(Arrays.toString(colors));
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        int[] colors = {0};
        solution.sortColors(colors);
        System.out.println(Arrays.toString(colors));
    }
}
