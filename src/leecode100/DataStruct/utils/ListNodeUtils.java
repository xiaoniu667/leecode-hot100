package leecode100.DataStruct.utils;

import leecode100.DataStruct.ListNode;
import leecode100.DataStruct.Node;

public class ListNodeUtils {
    // 封装的打印链表方法
    public static void printListNode(ListNode head) {
        ListNode current = head;
        if (current == null) {
            System.out.println("Empty list");
            return;
        }
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println(); // 换行
    }

    public static void printNode(Node head) {
        Node current = head;
        if (current == null) {
            System.out.println("Empty list");
            return;
        }
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println(); // 换行
    }

}
