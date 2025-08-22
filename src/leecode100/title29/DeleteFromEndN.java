package leecode100.title29;

import leecode100.DataStruct.ListNode;

import static leecode100.DataStruct.utils.ListNodeUtils.printListNode;

/**
 * 题目：
 * 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 */
public class DeleteFromEndN {

    /**
     * 思路：求出链表的长度，然后长度减去倒数的数，就是遍历到的结点下一个结点就是删除的及节点
     * 1 2 3 4 5
     */
    public static void main(String[] args) {
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode head = new ListNode(1);
        ListNode listNode = new DeleteFromEndN().removeNthFromEnd(head, 1);
        printListNode(listNode);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = length(head);
        int needLength = length - n;
        ListNode current = head;
        if (needLength == 0) {
            return head.next;  //考虑特殊情况
        }
        for (int i = 0; i < needLength - 1; i++) { //
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }

    public int length(ListNode head) {
        ListNode current = head;
        int length = 0;
        while (current != null) {
            current = current.next;
            length++;
        }
        return length;
    }

}
