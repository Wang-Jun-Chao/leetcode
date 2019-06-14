import java.util.HashSet;
import java.util.Set;

/**
 * Author: Íõ¿¡³¬
 * Date: 2015-06-21
 * Time: 08:48
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
//        test01();
//        test02();
        test03();
    }

    private static void test01() {
        Solution solution = new Solution();
        Set<String> set = new HashSet<>();
        set.add("leet");
        set.add("code");
        System.out.println(solution.wordBreak("leetcode", set));
    }

    private static void test02() {
        Solution solution = new Solution();
        Set<String> set = new HashSet<>();
        System.out.println(solution.wordBreak("a", set));
    }


    private static void test03() {
        Solution solution = new Solution();
        Set<String> set = new HashSet<>();
//        set.add("b");
        set.add("a");
        set.add("aa");
        set.add("aaa");
        set.add("aaaa");
        set.add("aaaaa");
        set.add("aaaaaa");
        set.add("aaaaaaa");
        set.add("aaaaaaaa");
        set.add("aaaaaaaaa");
        set.add("aaaaaaaaaa");
        System.out.println(solution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaab", set));
    }
}
