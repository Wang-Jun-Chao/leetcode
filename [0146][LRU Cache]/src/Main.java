import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-17 17:41
 **/
public class Main {

    @Test
    public void test1() {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        Assert.assertEquals(-1, cache.get(2));
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        Assert.assertEquals(-1, cache.get(1));
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}
