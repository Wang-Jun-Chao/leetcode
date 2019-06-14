import java.util.List;

/**
 * Author: Íõ¿¡³¬
 * Date: 2015-06-22
 * Time: 13:27
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> result = solution.grayCode(2);

        for (Integer i: result) {
            System.out.printf("%s\n", Integer.toBinaryString(i));
        }
    }
}
