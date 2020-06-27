import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Author: 王俊超
 * Date: 2015-06-30
 * Time: 19:21
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Merge k sorted linked lists and return it as one sorted list.
     * Analyze and describe its complexity.
     *
     * 题目大意：
     * 合并k个排好的的单链表
     *
     * 解题思路：
     * 使用一个小堆来进行操作，先将k个单链表的第一个结点入堆，再取堆中的最小素，此为最小的元素，
     * 将这个元素的下一个结点堆，再取堆中最小的，依次操作直到堆为空
     * </pre>
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        // 为空或者没有元素
        if (lists == null || lists.length < 1) {
            return null;
        }

        // 只有一个元素
        if (lists.length == 1) {
            return lists[0];
        }

        // 创建一个小顶堆，并且使用一个匿名内部类作为比较器
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1 == null) {
                    return -1;
                }

                if (o2 == null) {
                    return 1;
                }

                return o1.val - o2.val;
            }
        });

        // 将数组中链表的第一个结点入堆
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        // 头结点，作辅助使用
        ListNode head = new ListNode(0);
        // 当前处理的结点
        ListNode curr = head;

        while (!queue.isEmpty()) {
            ListNode node = queue.remove();

            // 结点的下一个结点不为空就将下一个结点入堆
            if (node.next != null) {
                queue.add(node.next);
            }

            curr.next = node;
            curr = node;
        }

        return head.next;
    }

}
