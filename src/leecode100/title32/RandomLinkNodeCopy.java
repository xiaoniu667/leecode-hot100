package leecode100.title32;

import leecode100.DataStruct.Node;
import leecode100.DataStruct.utils.ListNodeUtils;

/**
 * 题目：
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * 返回复制链表的头节点。
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 */
public class RandomLinkNodeCopy {

    /**
     * 思路：先复制链表的节点的next指针，原来是A -> B -> C
     * 复制完毕之后变为A -> A' -> B -> B' -> C -> C'
     * 然后复制random指针，比如A的random指向C，那么刚好A'指向C的next的后一个C'
     * 然后剔除原来的ABC那个节点即可。
     */
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;
        node1.random = node3;
        node2.random = node1;
        node3.random = node2;


        Node node = new RandomLinkNodeCopy().copyRandomList(node1);
        ListNodeUtils.printNode(node);
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //步骤1：先复制链表的节点的next指针
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            Node newNode = new Node(curr.val);
            curr.next = newNode;
            newNode.next = next;
            curr = next;
        }
        //步骤2：然后复制random指针
        Node work = head;
        while (work != null && work.next != null) {
            Node nextnext = work.next.next;
            if (work.random != null) {
                work.next.random = work.random.next;
            } else {
                work.next.random = null;
            }
            work = nextnext;
        }
        //步骤3：然后剔除原来的节点 A -> A' -> B -> B' -> C -> C'
        Node now = head;
        Node dumpy = new Node(0);
        dumpy.next = head.next;
        while (now != null && now.next != null) {
            Node next = now.next;
            now.next = now.next.next;
            now = next;
        }
        return dumpy.next;
    }
}
