import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-28 16:54
 **/
public class BSTIterator {
    private TreeNode root;
    private TreeNode prev = null;
    // 最后一个元素表示next元素的值
    private Deque<TreeNode> deque = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        this.root = root;
        TreeNode temp = root;
        // 找最左的子结点，并且将经过的路径都记录下来
        while (temp != null) {
            deque.addLast(temp);
            temp = temp.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {

        if (deque.isEmpty()) {
            throw new NoSuchElementException();
        }

        TreeNode temp = deque.removeLast();

        if (temp.right != null) {
            TreeNode n = temp.right;
            while (n != null) {
                deque.addLast(n);
                n = n.left;
            }
        }

        return temp.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !deque.isEmpty();
    }
}
