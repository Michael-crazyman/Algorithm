/**
 * Created by lishaoxun on 2016/6/26.
 */
public class Node {

    public int value;
    public Node next;

    public Node(int value){
        this.value = value;
    }

    public static Node removeLastKthNode(Node head,int k){
        if(head == null || k < 0){
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
            cur.next = cur.next.next;
        }

        return cur;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        head.next = node1;
        Node node2 = new Node(3);
        node1.next = node2;
        Node node3 = new Node(4);
        node2.next = node3;

        Node n = removeLastKthNode(head,3);
        while(n != null){
            System.out.print(" "+n.value+" ");
            n = n.next;
        }
        System.out.println();
    }
}
