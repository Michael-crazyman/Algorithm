import java.util.Stack;

/**
 * Created by lishaoxun on 2016/7/1.
 */
public class Node {

    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    public static Node addList(Node head1, Node head2) {

        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        Node node1 = head1;
        Node node2 = head2;
        while (node1 != null) {
            s1.push(node1);
            node1 = node1.next;
        }
        while (node2 != null) {
            s2.push(node2);
            node2 = node2.next;
        }

        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;

        Node pre = null;
        Node node = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            n1 = s1.isEmpty() ? 0 : s1.pop().value;
            n2 = s2.isEmpty() ? 0 : s2.pop().value;
            n = n1 + n2 + ca;
            pre = node;
            node = new Node(n % 10);
            node.next = pre;
            ca = n / 10;
        }

        if (ca == 1) {
            pre = node;
            node = new Node(n % 10);
            node.next = pre;
        }


        return node;
    }

    public static void main(String[] args) {
        Node node10 = new Node(1);
        Node node11 = new Node(2);
        node10.next = node11;
        Node node12 = new Node(3);
        node11.next = node12;

        Node node20 = new Node(2);
        Node node21 = new Node(4);
        node20.next = node21;
        Node n = addList(node10,node20);
        while(n != null){
            System.out.print(" value = "+n.value);
            n = n.next;
        }
    }
}
