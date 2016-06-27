/**
 * Created by lishaoxun on 2016/6/26.
 */
public class Node {

    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    public static void printCommonPart(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            System.out.println("This is a bad thing");
        }
        System.out.print("The Common part : ");
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.print(head1.value+" ");
                head1 = head1.next;
                head2 = head2.next;

            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(-1);
        Node head2 = new Node(1);

        Node temp1 = new Node(1);
        head1.next = temp1;
        Node temp3 = new Node(2);
        temp1.next = temp3;


        Node temp2 = new Node(2);
        head2.next = temp2;
        Node temp4 = new Node(3);
        temp2.next = temp4;

        Node n = head1;
        while(n != null){
            Node temp = n;
            int data = temp.value;
            System.out.print("The value = "+data);
            n = n.next;
        }

        printCommonPart(head1, head2);

    }


}
