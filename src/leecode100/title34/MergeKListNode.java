package leecode100.title34;

import leecode100.DataStruct.ListNode;
import leecode100.DataStruct.utils.ListNodeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：合并 K 个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [1->4->5,1->3->4,2->6]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 */
public class MergeKListNode {

    /**
     * 思路：将链表中的数据放入到数组之中，然后进行排序，排完序之后再合并成链表
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,null))));
        ListNode head1 = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,null))));
        ListNode head2 = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,null))));
        ArrayList<ListNode> lists = new ArrayList<>();
        lists.add(head);
        lists.add(head1);
        lists.add(head2);
        ListNode[] listNodes = lists.toArray(new ListNode[0]);
        ListNode listNode = new MergeKListNode().mergeKLists(listNodes);
        ListNodeUtils.printListNode(listNode);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int length = 0;
        for (int i = 0; i < lists.length; i++) {
            ListNode currentNode = lists[i];
            while (currentNode!=null){
                currentNode = currentNode.next;
                length++;
            }
        }
        int[] nums = new int[length];
        length = 0;
        for (int i = 0; i < lists.length; i++) {
            ListNode currentNode = lists[i];
            while (currentNode!=null){
                nums[length] = currentNode.val;
                currentNode = currentNode.next;
                length++;
            }
        }
        Arrays.sort(nums);
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int i = 0; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        return dummy.next;
    }
}
