/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-06 21:27
 **/
public class Solution {
    public Node construct(int[][] grid) {

        if (grid == null) {
            return null;
        }

        Node node = new Node();

        construct(node, grid, 0, 0, grid.length);
        return node;
    }

    private void construct(Node node, int[][] grid, int x, int y, int size) {

        if (size <= 0) {
            return;
        }

        if (size == 1) {
            node.isLeaf = true;
            node.val = grid[x][y] == 1;
            return;
        }

        int half = size / 2;

        Node topLeft = new Node();
        Node topRight = new Node();
        Node bottomLeft = new Node();
        Node bottomRight = new Node();


        construct(topLeft, grid, x, y, half);
        construct(topRight, grid, x, y + half, half);
        construct(bottomLeft, grid, x + half, y, half);
        construct(bottomRight, grid, x + half, y + half, half);

        // 四个孩子都是叶子节点，并且值都相等
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
            if (topLeft.val && topRight.val && bottomLeft.val && bottomRight.val) {
                node.isLeaf = true;
                node.val = true;
                return;
            } else if (!topLeft.val && !topRight.val && !bottomLeft.val && !bottomRight.val) {
                node.isLeaf = true;
                node.val = false;
                return;
            }
        }

        node.isLeaf = false;
        node.topLeft = topLeft;
        node.topRight = topRight;
        node.bottomLeft = bottomLeft;
        node.bottomRight = bottomRight;
    }
}
