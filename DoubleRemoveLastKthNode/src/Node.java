/**
 * Created by lishaoxun on 2016/6/26.
 */
public class Node {

    /**
     * remove the last kth node
     */

    public int value;
    public Node next;
    public Node last;

    public Node(int value) {
        this.value = value;
    }

    public static Node removeLastKthNodeWithDouble(Node head, int k) {

        if (head == null || k < 0) {
            return head;
        }

        Node cur = head;
        while(cur != null){
            --k;
            cur = cur.next;
        }

        if(k > 0){
            return head;
        }
        if(k == 0){
            return head.next;
        }
        if(k < 0){
            cur = head;
            while(++k != 0){
                cur = cur.next;
            }
            Node newNext = cur.next.next;
            cur.next = newNext;
            if(newNext != null) {
                newNext.last = cur;
            }

        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);

        head.next = node1;
        node1.last = head;

        node1.next = node2;
        node2.last = node1;

        node2.next = node3;
        node3.last = node2;

        node4.next = null;
        node4.last = node3;

        Node n = removeLastKthNodeWithDouble(head,4);
        //Node n = head;
        while(n != null){
            System.out.print("data = "+n.value);
            System.out.print(" ");
            n = n.next;
        }
    }
}
