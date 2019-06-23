/**
 * Author: Íõ¿¡³¬
 * Date: 2015-06-20
 * Time: 09:50
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println("|" +solution.reverseWords(" ") + "|");

//        char[] array = "   a   b ".toCharArray();
//        int len = solution.compressWhiteSpace(array);
//        System.out.println("|" + new String(array, 0, len) + "|");

//        System.out.println(solution.reverseWords(""));
//        System.out.println(solution.reverseWords("   a   "));
//        System.out.println(solution.reverseWords("         "));
//        System.out.println(solution.reverseWords("   a   b "));
        System.out.println(solution.reverseWords("   a   b  c d   e  "));
        System.out.println(solution.reverseWords("a   b  c d   e"));
        System.out.println(solution.reverseWords("abcdef"));

    }

}
