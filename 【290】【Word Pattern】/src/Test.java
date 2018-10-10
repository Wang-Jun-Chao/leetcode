/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-10 17:29
 **/
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
        System.out.println(solution.wordPattern("abba", "dog cat cat fish"));
        System.out.println(solution.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(solution.wordPattern("abba", "dog dog dog dog"));
    }
}
