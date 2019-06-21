import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-20 08:17
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new LinkedList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        Assert.assertEquals(5, solution.ladderLength(beginWord, endWord, wordList));
    }
}
