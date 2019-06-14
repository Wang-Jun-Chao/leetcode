/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-10 11:25
 **/
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        System.out.println(solution.binaryTreePaths(root));
    }
}
