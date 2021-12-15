package com.pratice.LinkedList;

public class Sol24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1,head);
        ListNode cur = dummy;
        while (cur.next!=null && cur.next.next!=null){
            ListNode temp1 = cur.next.next.next;
            ListNode temp2 = cur.next;

            cur.next = cur.next.next;
            cur.next.next = temp2;
            cur.next.next.next = temp1;

            //cur移动两位，准备进行下一轮交换
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
