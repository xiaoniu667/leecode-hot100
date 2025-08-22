package leecode100.title33;

import leecode100.DataStruct.ListNode;
import leecode100.DataStruct.utils.ListNodeUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 链接：https://leetcode.cn/problems/sort-list/?envType=study-plan-v2&envId=top-100-liked
 * 题目：排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class SortLinkNode {


    /**
     * 思路：将链表放入数组之中，然后进行排序，排完序之后再恢复成链表即可
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(2,new ListNode(1,null))));
        ListNode listNode = new SortLinkNode().sortList(head);
        ListNodeUtils.printListNode(listNode);
    }

    public ListNode sortList(ListNode head) {
        int length = getLength(head);
        int[] num = new int[length];
        ListNode work = head;
        for (int i = 0; i < length; i++) {
            num[i] = work.val;
            work = work.next;
        }
        Arrays.sort(num);
        ListNode dumpy = new ListNode(0);
        ListNode current = dumpy;
        for (int i = 0; i < num.length; i++) {
            current.next = new ListNode(num[i]);
            current = current.next;
        }
        return dumpy.next;
    }

    public int getLength(ListNode head) {
        ListNode current = head;
        int length = 0;
        while (current != null) {
            current = current.next;
            length++;
        }
        return length;
    }

}
