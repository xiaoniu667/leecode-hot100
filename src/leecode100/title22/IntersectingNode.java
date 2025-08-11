package leecode100.title22;

import leecode100.DataStruct.ListNode;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/?envType=study-plan-v2&envId=top-100-liked
 * 相交链表：
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * 链表 A：1 -> 2 -> 3 -> 4 -> 5
 * 链表 B：6 -> 4 -> 5
 */
public class IntersectingNode {

    /**
     * 思路：由于A和B的长度不同，不好比较。
     * 可以遍历的时候，如果A遍历完了，可以遍历B。B遍历完了，可以遍历A。
     */
    public static void main(String[] args) {
        // 创建共享节点：4 -> 5
        ListNode common = new ListNode(4, new ListNode(5, null));
        // 链表 A: 1 -> 2 -> 3 -> 4 -> 5
        ListNode headA = new ListNode(1, new ListNode(2, new ListNode(3, common)));
        // 链表 B: 6 -> 4 -> 5
        ListNode headB = new ListNode(6, common);
        ListNode intersectionNode = new IntersectingNode().getIntersectionNode(headA, headB);
        System.out.println(intersectionNode != null ? intersectionNode.val : "null");
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null; // 空链表无交点
        }
        ListNode currentA = headA; //工作结点
        ListNode currentB = headB;
        while (currentA != currentB) {
            if (currentA == null) {
                currentA = headB;
            } else {
                currentA = currentA.next;
            }
            if (currentB == null) {
                currentB = headA;
            } else {
                currentB = currentB.next;
            }
        }
        return currentA;
    }

}
