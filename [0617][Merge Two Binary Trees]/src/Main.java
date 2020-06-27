import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-04 09:00
 **/
public class Main {
    @Test
    public void test1() {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.left.left = new TreeNode(5);
        t1.right = new TreeNode(2);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.left.right = new TreeNode(4);
        t2.right = new TreeNode(3);
        t2.right.right = new TreeNode(7);

        Solution solution = new Solution();

        TreeNode node = solution.mergeTrees(t1, t2);

        print(node);
    }

    private void print(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + ", ");
            print(node.left);
            print(node.right);
        }
    }
}
