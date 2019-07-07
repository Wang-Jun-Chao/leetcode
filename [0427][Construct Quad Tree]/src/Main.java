import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-06 21:40
 **/
public class Main {
    @Test
    public void test1() {
        int[][] grid = {
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
        };

        Solution solution = new Solution();
        Node node = solution.construct(grid);
        print(node);
    }

    private static void print(Node node) {
        if (node != null) {
            System.out.println("(" + node.isLeaf + ", " + node.val + ")");
            print(node.topLeft);
            print(node.topRight);
            print(node.bottomLeft);
            print(node.bottomRight);
        }
    }
}
