import org.junit.Assert;
import org.junit.Test;

public class TestSolution {
    @Test
    public void test1() {
        String[][] data = {{"1807", "7810", "1A3B"}, {"1123", "0111", "1A1B"}, {"11", "10", "1A0B"}};

        for (String[] datum : data) {
            String result = new Solution().getHint(datum[0], datum[1]);
            Assert.assertEquals(result, datum[2]);
        }
    }
}
