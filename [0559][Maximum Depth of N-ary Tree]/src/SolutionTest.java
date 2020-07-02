import org.junit.Assert;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Author: 王俊超
 * Time: 2020-07-02 08:00
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void maxDepth() {
        Node root = new Node(1);
        root.children = new ArrayList<>();
        root.children.add(new Node(3));
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        root.children.get(0).children = new ArrayList<>();
        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));

        Solution s  =new Solution();

        Assert.assertEquals(3, s.maxDepth(root));
    }
}