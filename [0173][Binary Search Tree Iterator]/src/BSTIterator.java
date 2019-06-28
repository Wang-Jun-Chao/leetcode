import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-28 16:54
 **/
public class BSTIterator {
    private TreeNode        root;
    private TreeNode        curr;
    private Deque<TreeNode> deque = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        this.root = root;
    }

    /**
     * @return the next smallest number
     */
    public int next() {

        if (curr == null) {
            curr = root;
            while (curr.left != null) {
                deque.addLast(curr);
                curr = curr.left;
            }

            return curr.val;
        } else {
            if (curr.right != null) {

                deque.addLast(curr.right);
                curr = curr.right;
                while (curr.left != null) {
                    deque.addLast(curr.left);
                    curr = curr.left;
                }


                curr = deque.removeLast();
                return curr.val;
            } else {
                curr = deque.removeLast();
                if (curr.right != null) {
                    deque.addLast(curr.right);
                }
                return curr.val;
            }
        }

    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return curr == null || (curr.left != null || curr.right != null) || !deque.isEmpty();
    }
}
