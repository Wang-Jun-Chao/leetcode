import org.junit.Test;

import java.util.List;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-28 16:29
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();

        print(solution.generateTrees(3));
    }

    private void print(List<TreeNode> generateTrees) {
        for (TreeNode node : generateTrees) {
            print(node);
            System.out.println();
        }
    }

    private void print(TreeNode node) {
        if (node != null) {
            System.out.print(node + ", ");

            if (node.left == null && node.right == null) {
                return;
            }

            if (node.left == null) {
                System.out.print("null, ");
            } else {
                print(node.left);
            }
            if (node.right == null) {
                System.out.print("null, ");
            } else {
                print(node.right);
            }
        }
    }
}
