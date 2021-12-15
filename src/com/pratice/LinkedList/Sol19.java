package com.pratice.LinkedList;

public class Sol19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1,head);

        ListNode slow = dummy;
        ListNode fast = dummy;
        while (n>0){
            fast = fast.next;
            n--;
        }
        //为了slow可以移动到待删除元素的前一个元素的位置，fast再往前走一步（画图理解）
        fast = fast.next;
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
