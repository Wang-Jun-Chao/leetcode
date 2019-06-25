import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: Íõ¿¡³¬
 * Date: 2015-06-21
 * Time: 08:48
 * Declaration: All Rights Reserved !!!
 */
public class Main {


    @Test
    public void test01() {
        Solution solution = new Solution();
        Set<String> set = new HashSet<>();
        set.add("leet");
        set.add("code");
        System.out.println(solution.wordBreak("leetcode", set));
    }

    @Test
    public void test02() {
        Solution solution = new Solution();
        Set<String> set = new HashSet<>();
        System.out.println(solution.wordBreak("a", set));
    }

    @Test
    public void test03() {
        Solution solution = new Solution();
        Set<String> set = new HashSet<>();
        set.add("b");
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

    @Test
    public void test04() {
        Solution solution = new Solution();
        Set<String> set = new HashSet<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));

        System.out.println(solution.wordBreak("catsandog", set));
    }
}
