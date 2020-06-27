import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-01 14:50
 **/
public class Main {
    @Test
    public void test1() {
        Node root = new Node();
        root.val = 1;
        List<Node> children = new LinkedList<>();
        Node n1 = new Node();
        n1.val = 3;
        Node n2 = new Node();
        n2.val = 2;
        Node n3 = new Node();
        n3.val = 4;
        children.add(n1);
        children.add(n2);
        children.add(n3);
        root.children = children;

        List<Node> children2 = new LinkedList<>();
        Node n4 = new Node();
        n4.val = 5;
        Node n5 = new Node();
        n5.val = 6;

        children2.add(n4);
        children2.add(n5);
        root.children.get(0).children = children2;

        Solution solution = new Solution();
        System.out.println(solution.levelOrder(root));
    }

    @Test
    public void test2() {

        Solution solution = new Solution();
        System.out.println(solution.levelOrder(null));
    }
}
