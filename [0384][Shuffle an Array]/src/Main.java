import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-02 15:56
 **/
public class Main {
    @Test
    public void test1() {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution(nums);

        int[] shuffle = solution.shuffle();
        System.out.println(Arrays.toString(shuffle));

        int[] reset = solution.reset();
        Assert.assertArrayEquals(nums, reset);

        shuffle = solution.shuffle();
        System.out.println(Arrays.toString(shuffle));
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Solution solution = new Solution(nums);

        int[] shuffle = solution.shuffle();
        System.out.println(Arrays.toString(shuffle));

        int[] reset = solution.reset();
        Assert.assertArrayEquals(nums, reset);

        shuffle = solution.shuffle();
        System.out.println(Arrays.toString(shuffle));
    }
}
