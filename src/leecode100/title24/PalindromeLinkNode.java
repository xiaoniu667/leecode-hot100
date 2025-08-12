package leecode100.title24;

import leecode100.DataStruct.ListNode;

/**
 * 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 输入：head = [1,2,2,1]
 * 输出：true
 */
public class PalindromeLinkNode {
    /**
     * 思路：使用快慢指针找到中心结点，进行反转链表
     * 然后从头结点和中心结点之后开始遍历比较，如果值是一样的，是回文链表，如果不是一样的，就不是回文链表。
     */
    public static void main(String[] args) {
        ListNode headA = new ListNode(1,new ListNode(2,new ListNode(2,new ListNode(1,null))));
        boolean palindrome = new PalindromeLinkNode().isPalindrome(headA);
        System.out.println(palindrome);
    }


    //  1,2,2,1
    public boolean isPalindrome(ListNode head) {
        // 寻找中间节点（快慢指针）
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //翻转链表
        ListNode pre = null;
        ListNode current =  slow;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        //开始比较
        ListNode workNode = head;
        while (pre != null) {
            if (pre.val != workNode.val) {
                return false;
            }
            pre = pre.next;
            workNode = workNode.next;
        }
        return true;
    }

}

