import java.util.Arrays;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-10 17:11
 **/
public class Test {
    public static void main(String[] args) {
        moveZeros(new int[]{0, 1, 0, 3, 12});
        moveZeros(new int[]{2, 1, 6, 3, 12});
        moveZeros(new int[]{2});
        moveZeros(new int[]{0});
    }

    private static void moveZeros(int[] a1) {
        Solution solution = new Solution();
        solution.moveZeroes(a1);
        System.out.println(Arrays.toString(a1));
    }
}
