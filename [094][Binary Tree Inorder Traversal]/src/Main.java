import java.util.List;

/**
 * Author: Íõ¿¡³¬
 * Date: 2015-07-25
 * Time: 18:33
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n1.left = n2;
        n1.right = n3;

        Solution solution = new Solution();
        List<Integer> result = solution.inorderTraversal(n1);
        System.out.println(result);
    }
}
