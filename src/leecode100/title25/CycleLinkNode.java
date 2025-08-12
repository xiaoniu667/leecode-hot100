package leecode100.title25;

import leecode100.DataStruct.ListNode;

import java.util.List;

/**
 * 环形链表：
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false。
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 */
public class CycleLinkNode {

    /**
     * 思路：利用快慢指针，如果快指针追上了慢指针，代表存在环形链表，如果没有追上fast为null的话，说明没有环。
     */
    public static void main(String[] args) {
//// 创建有环链表
//        ListNode head1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        head1.next = node2;
//        node2.next = node3;
//        node3.next = node2; // 形成环
//        System.out.println("有环链表测试结果: " + solution.hasCycle(head1)); // 输出: true




        ListNode head1 = new ListNode(1);
        boolean result = new CycleLinkNode().hasCycle(head1);
        System.out.println(result);
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // 慢指针走一步
            fast = fast.next.next; // 快指针走两步
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
