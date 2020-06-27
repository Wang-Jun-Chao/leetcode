import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-11 13:34
 **/
public class Main {
    @Test
    public void test1() {
        char[][] board = {
                {'X', '.', ',', 'X'},
                {'.', '.', ',', 'X'},
                {'.', '.', ',', 'X'}
        };

        Solution solution = new Solution();
        Assert.assertEquals(2, solution.countBattleships(board));
    }
}
