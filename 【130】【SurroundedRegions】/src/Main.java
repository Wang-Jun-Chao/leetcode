/**
 * Author: Íõ¿¡³¬
 * Date: 2015-06-22
 * Time: 10:02
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
//        test01();
//        test02();
//        test03();
        test04();
    }


    private static void test01() {
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
    }

    private static void test02() {
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
    }

    private static void test03() {
        Solution solution = new Solution();
        char[][] board = {
                "OO".toCharArray(),
                "OO".toCharArray()
        };

        solution.solve(board);

        for (char[] line : board) {
            System.out.println(new String(line));
        }
    }

    private static void test04() {
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
    }
}
