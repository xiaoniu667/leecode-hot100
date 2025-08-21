package leecode100.title31;

import leecode100.DataStruct.ListNode;

/**
 * 题目：K个一组翻转链表
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 */
public class K_ReverseLinkNode {

    /**
     * 思路：上一题两两翻转的扩展版
     * 维护几个指针prev end start 遍历找到待翻转组的前一个节点以及当前翻转组的头节点
     * 将头节点到待翻转组的前一个节点进行翻转 依次循环直到end的下一个节点为null，或者不足k个节点
     */
    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;

        ListNode prev = dumpy;
        ListNode end = dumpy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            //end为翻转组的前一个节点
            if (end == null) {  //如果不足k的节点，直接跳出循环
                break;
            }
            ListNode next = end.next;  //待翻转区域的头结点
            end.next = null; //断链
            ListNode start = prev.next; //开始翻转的头结点
            prev.next = null;

            //开始链表的翻转
            //3,2,1,4,5,6
            prev.next = reverseListNode(start);
            start.next = next; //连接待翻转区域的头结点
            prev = start;     //prev = 1
            end = start;      // end = 1
        }
        return dumpy.next;

    }

    //进行链表的翻转  123
    private ListNode reverseListNode(ListNode start) {
        ListNode prev = null;
        ListNode curr = start;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

}
