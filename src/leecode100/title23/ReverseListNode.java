package leecode100.title23;

import leecode100.DataStruct.ListNode;

import java.util.List;

import static leecode100.DataStruct.utils.PrintListNode.printList;

/**
 * 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 */
public class ReverseListNode {

    /***
     * 思路：给定一个单链表，例如 1 -> 2 -> 3 -> 4 -> 5，我们需要将其反转为 5 -> 4 -> 3 -> 2 -> 1。输入是链表的头节点，返回反转后的头节点。
     * 遍历链表，依次改变每个节点的 next 指针，使其指向前一个节点。
     * 为了避免在反转过程中丢失后续节点，需要在每次操作时保存当前节点的下一个节点。
     * 同时，需要跟踪前一个节点，以便将当前节点的 next 指针指向它。
     * 所以需要三个指针pre current next
     * 遍历链表，直到 curr 为空：
     * 保存 curr 的下一个节点：next = curr.next。
     * 将 curr 的 next 指针指向 prev，实现反转：curr.next = prev。
     * 更新 prev 为当前节点：prev = curr。
     * 移动 curr 到下一个节点：curr = next。
     * 遍历结束后，prev 指向反转后的头节点。
     *
     */

    public static void main(String[] args) {
        ListNode headA = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        ListNode listNode = new ReverseListNode().reverseList(headA);
        printList(listNode);
    }

    //    1 -> 2
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            //处理当前的结点
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
}
