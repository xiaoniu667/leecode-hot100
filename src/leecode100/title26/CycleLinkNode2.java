package leecode100.title26;

import leecode100.DataStruct.ListNode;

/**
 * 环形链表2：
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 */
public class CycleLinkNode2 {

    /**
     * 思路：快指针是慢指针的两倍 如果链表存在环的话，那么快指针一定会相遇到慢指针。快指针的速度是慢指针速度的2倍。
     * 假设有环存在相遇点，那么起点到环的入口的距离假设为x,入口到相遇点为y,相遇点到入口的距离为z。
     * 那么就有这么一个公式:
     * 2(x+y) = x+n(y+z)
     * x = (n-1)(y+z)+z
     * 假设n为1的话，那么 x= z 如果存在环的话说明起点到环的距离等于相遇点到入口的距离。
     */
    public static void main(String[] args) {
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                //相遇了
                ListNode index1 = head;
                ListNode index2 = fast;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
