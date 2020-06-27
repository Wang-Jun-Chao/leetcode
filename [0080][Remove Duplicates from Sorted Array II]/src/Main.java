import java.util.Arrays;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-12 22:29
 **/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int i = solution.removeDuplicates(nums);
        System.out.println(i + ": " + Arrays.toString(nums));

    }
}
