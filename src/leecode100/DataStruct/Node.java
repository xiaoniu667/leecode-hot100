package leecode100.DataStruct;

public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int val, Node random, Node next) {
        this.val = val;
        this.random = random;
        this.next = next;
    }
}
