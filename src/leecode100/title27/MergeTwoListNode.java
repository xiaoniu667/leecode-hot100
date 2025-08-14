package leecode100.title27;

import leecode100.DataStruct.ListNode;

/**
 * 题目：将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class MergeTwoListNode {

    /**
     * 思路：
     * 1.初始化：
     * -创建一个虚拟头节点（dummy node）作为新链表的起点，方便处理合并后的链表。
     * -使用一个指针（current）来构建新链表，初始指向虚拟头节点。
     * 2.比较与拼接：
     * -同时遍历 list1 和 list2，比较当前节点的值：
     * -如果 list1 的节点值小于等于 list2 的节点值，选择 list1 的节点，将其接到新链表的 current 指针后，并移动 list1 指针。
     * -否则，选择 list2 的节点，接到 current 指针后，并移动 list2 指针。
     * 3.每次选择节点后，移动 current 指针到新拼接的节点。
     * 处理剩余节点：
     * 当其中一个链表遍历完（即为空），将另一个链表的剩余部分直接接到新链表的末尾。
     * 4.返回结果：
     * 返回虚拟头节点的下一个节点作为新链表的头节点。
     */

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                current.next = list2;
                list2 = list2.next;
            } else {
                current.next = list1;
                list1 = list1.next;
            }
            current = current.next;
        }
        current.next = list1 != null ? list1 : list2;
        return dummy.next;
    }
}
