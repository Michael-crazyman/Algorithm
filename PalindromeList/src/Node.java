import java.util.Stack;

/**
 * Created by lishaoxun on 2016/6/28.
 */
public class Node {

    public int value;
    public Node next;

    public Node(int data){
        this.value = data;
    }


    public static boolean isPalindromeList(Node head){

        if(head == null){
            return false;
        }
        Stack<Node> stack = new Stack<>();
        Node node1 = head;
        while(node1 != null){
            stack.push(node1);
            node1 = node1.next;
        }
        Node node2 = head;
        while(node2 != null){
            Node temp = stack.pop();
            if(temp.value != node2.value){
                return false;
            }
            node2 = node2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(2);
        Node node4 = new Node(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        boolean x = isPalindromeList(head);
        System.out.println(x);


    }
}
