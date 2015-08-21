/**
 * Author: Íõ¿¡³¬
 * Date: 2015-06-23
 * Time: 10:32
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inorder = {1,2,3,4};
        int[] postorder = {3,2,4,1};

        TreeNode root = solution.buildTree(inorder, postorder);
        print(root);
    }

    public static void print(TreeNode root) {
        if (root != null) {
            print(root.left);
            System.out.print(root.val + " ");
            print(root.right);
        }
    }
}
