/**
 * Created by lishaoxun on 2016/6/26.
 */
public class Node {

    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    public static Node reverseList(Node head) {

        if(head == null){
            return head;
        }

        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        head.next = node1;
        Node node2 = new Node(3);
        node1.next = node2;
        Node node3 = new Node(4);
        node2.next = node3;

        Node tmp = head;
        System.out.print("The old : ");
        while(tmp != null){
            System.out.print(tmp.value);
            System.out.print(" ");
            tmp = tmp.next;
        }
        System.out.println();
        Node n = reverseList(head);
        System.out.print("And Now : ");
        while(n != null){
            System.out.print(n.value);
            System.out.print(" ");
            n = n.next;
        }
        System.out.println();
    }
}
