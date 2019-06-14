import java.util.Arrays;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-10 14:14
 **/
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        missingNumber(solution, new int[]{0});
        missingNumber(solution, new int[]{3, 0, 1});
        missingNumber(solution, new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1});
        missingNumber(solution, new int[]{8, 6, 4, 2, 3, 5, 7, 0, 1});
    }

    private static void missingNumber(Solution solution, int[] array) {
        System.out.println(solution.missingNumber(array));
        System.out.println(Arrays.toString(array));
    }
}
