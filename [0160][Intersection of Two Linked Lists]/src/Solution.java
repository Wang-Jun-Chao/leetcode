//Write a program to find the node at which the intersection of two singly linke
//d lists begins.
//
// For example, the following two linked lists:
//
//
// begin to intersect at node c1.
//
//
//
// Example 1:
//
//
//
//Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2
//, skipB = 3
//Output: Reference of the node with value = 8
//Input Explanation: The intersected node's value is 8 (note that this must not
//be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. F
//rom the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the inter
//sected node in A; There are 3 nodes before the intersected node in B.
//
//
//
// Example 2:
//
//
//
//Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skip
//B = 1
//Output: Reference of the node with value = 2
//Input Explanation: The intersected node's value is 2 (note that this must not
//be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. F
//rom the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected
// node in A; There are 1 node before the intersected node in B.
//
//
//
//
// Example 3:
//
//
//
//Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//Output: null
//Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B
//, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be
//0, while skipA and skipB can be arbitrary values.
//Explanation: The two lists do not intersect, so return null.
//
//
//
//
// Notes:
//
//
// If the two linked lists have no intersection at all, return null.
// The linked lists must retain their original structure after the function returns.
// You may assume there are no cycles anywhere in the entire linked structure.
// Your code should preferably run in O(n) time and use only O(1) memory.
//
// Related Topics Linked List


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    /**
     * 解题思路：将headA链表的尾结点链接到headB的头部，问题等价于求链表中环的入口节点，最后再还原两个表
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        if (headA == headB) {
            return headA;
        }

        ListNode tailA = headA;
        while (tailA.next != null) {
            tailA = tailA.next;
        }

        tailA.next = headB;

        // 定义快慢指针
        ListNode fast = headA;
        ListNode slow = headA;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            //如果有环，想遇于环中某点
            if (fast == slow) {
                break;
            }
        }

        //如果没有环，return null
        if (fast.next == null || fast.next.next == null) {
            tailA.next = null; // 还原链表
            return null;
        }

        slow = headA;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }


        tailA.next = null; // 还原链表
        return fast;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
