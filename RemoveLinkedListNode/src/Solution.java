/**
 * Created by lishaoxun on 2016/7/4.
 */
public class Solution {

    /**
     *
     * 此方法已经经过leetcode验证，并且已经被accepted.
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {

        if(head == null){
            return head;
        }
        //设pre为上一个val不为原来的val的节点
        //cur为当前正在被访问的节点

        ListNode pre = null;
        ListNode cur = null;
        //先找到第一个不是val的节点,这个节点就是新的头节点
        cur = head;
        while(cur != null){
            if(cur.val != val)
                //这里只会产生第一个不是val的节点
                break;

            cur = cur.next;
        }

        pre = cur;
        head = cur;

        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            }else{
                //更新pre
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }


}
