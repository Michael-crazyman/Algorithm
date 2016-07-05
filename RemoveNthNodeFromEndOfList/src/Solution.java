/**
 * Created by lishaoxun on 2016/7/5.
 */
public class Solution {

    /**
     *
     * 以下方法已经过leetcode验证，并且已经accepted!
     * @param head
     * @param n
     * @return
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null || n < 0){
            return head;
        }


        ListNode fast = head;
        ListNode slow = head;

        for(int i = 0;i < n;i++){
            fast = fast.next;
        }
        if(fast == null){
            return head.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }
}
