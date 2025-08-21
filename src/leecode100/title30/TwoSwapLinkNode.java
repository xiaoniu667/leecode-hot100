package leecode100.title30;

import leecode100.DataStruct.ListNode;
import leecode100.DataStruct.utils.PrintListNode;

/**
 * 题目：
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class TwoSwapLinkNode {
    /**
     * 思路：
     * 具体步骤（以 1->2->3->4 为例）
     * <p>
     * 初始状态：
     * <p>
     * 链表是：dummy->1->2->3->4。
     * 裁判（dummy）先指向 1，1 指向 2，2 指向 3，3 指向 4。
     * 我们用两个指针：prev 指向裁判（dummy），cur 指向 1。
     * <p>
     * <p>
     * 第一对交换（1 和 2）：
     * <p>
     * 现在要让 1 和 2 换位置，目标是变成 dummy->2->1->3->4。
     * 具体操作：
     * <p>
     * 先记住 2 的下一个节点（3），免得等会儿找不到。
     * 让 1 的手（next 指针）指向 3（跳过 2）。
     * 让 2 的手指向 1（2 变成前面的）。
     * 让裁判的手指向 2（2 变成新头）。
     * <p>
     * <p>
     * 结果：dummy->2->1->3->4。
     * 更新指针：prev 移到 1，cur 移到 3（准备下一对）。
     * <p>
     * <p>
     * 第二对交换（3 和 4）：
     * <p>
     * 现在处理 3 和 4，目标是变成 dummy->2->1->4->3。
     * 同样操作：
     * <p>
     * 记住 4 的下一个节点（这里是 null，没下一个了）。
     * 让 3 的手指向 null（跳过 4）。
     * 让 4 的手指向 3。
     * 让 1 的手（因为 1 是现在的 prev）指向 4。
     * <p>
     * <p>
     * 结果：dummy->2->1->4->3。
     * 此时 cur 移到 null，说明没节点可换了，结束。
     * <p>
     * <p>
     * 返回结果：
     * <p>
     * 裁判（dummy）的 next 指向 2，所以返回 2 作为新链表的头。
     * 最终链表：2->1->4->3。
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        ListNode listNode = new TwoSwapLinkNode().swapPairs(head);
        PrintListNode.printListNode(listNode);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;
        ListNode current = head;
        ListNode pre = dumpy;
        while (current != null && current.next != null) {  //1234
            ListNode nextnext = current.next.next;  //记录节点
            ListNode next = current.next;   //记录节点
            current.next = nextnext;     //1->3   213
            next.next = current;   //2->1
            pre.next = next;   //更新变化完之后，pre连接下一个节点
            pre = current;    //更新pre节点
            current = current.next;  //移动current节点
        }
        return dumpy.next;
    }
}
