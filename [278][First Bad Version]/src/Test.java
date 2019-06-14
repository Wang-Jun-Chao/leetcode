/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-10 16:55
 **/
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.setBadVersion(new boolean[]{false, false, false, true, true});
        System.out.println(solution.firstBadVersion(5));
    }
}
