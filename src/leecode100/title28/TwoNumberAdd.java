package leecode100.title28;

import leecode100.DataStruct.ListNode;

/**
 * 两数相加：
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class TwoNumberAdd {
    /**
     * 思路：两数相加 当前为就是sum%10 进位就是sum//10 sum为两数相加再加上进位carry
     */
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int currentVal = sum % 10; //当前值
            carry = sum / 10;  //进位
            current.next = new ListNode(currentVal);
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l2!=null) {
            int sum = l2.val + carry;
            int currentVal = sum % 10; //当前值
            carry = sum / 10;  //进位
            current.next = new ListNode(currentVal);
            current = current.next;
            l2 = l2.next;
        }
        while (l1!=null){
            int sum = l1.val + carry;
            int currentVal = sum % 10; //当前值
            carry = sum / 10;  //进位
            current.next = new ListNode(currentVal);
            current = current.next;
            l1 = l1.next;
        }
        if (carry == 1) {   //漏掉了进位
            current.next = new ListNode(1);
        }
        return dummy.next;
    }
}
