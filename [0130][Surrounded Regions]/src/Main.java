import org.junit.Test;

/**
 * Author: Íõ¿¡³¬
 * Date: 2015-06-22
 * Time: 10:02
 * Declaration: All Rights Reserved !!!
 */
public class Main {

    @Test
    public void test01() {
        Solution solution = new Solution();
        char[][] board = {
                "XXXX".toCharArray(),
                "XOOX".toCharArray(),
                "XXOX".toCharArray(),
                "XOXX".toCharArray()
        };

        solution.solve(board);

        for (char[] line : board) {
            System.out.println(new String(line));
        }
        System.out.println();
    }

    @Test
    public void test02() {
        Solution solution = new Solution();
        char[][] board = {
                "XOXX".toCharArray(),
                "OXOX".toCharArray(),
                "XOXO".toCharArray(),
                "OXOX".toCharArray(),
                "XOXO".toCharArray(),
                "OXOX".toCharArray()
        };

        solution.solve(board);

        for (char[] line : board) {
            System.out.println(new String(line));
        }
        System.out.println();
    }

    @Test
    public void test03() {
        Solution solution = new Solution();
        char[][] board = {
                "OO".toCharArray(),
                "OO".toCharArray()
        };

        solution.solve(board);

        for (char[] line : board) {
            System.out.println(new String(line));
        }
        System.out.println();
    }

    @Test
    public void test04() {
        Solution solution = new Solution();
        char[][] board = {
                "OOO".toCharArray(),
                "OOO".toCharArray(),
                "OOO".toCharArray()
        };

        solution.solve(board);

        for (char[] line : board) {
            System.out.println(new String(line));
        }
        System.out.println();
    }
}
