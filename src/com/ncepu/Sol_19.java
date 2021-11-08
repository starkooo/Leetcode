package com.ncepu;

public class Sol_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        //先走n步，后走到end的指针
        ListNode end = dummyHead;
        //等end走到尽头才开始走的指针
        ListNode start = dummyHead;

        while (n!=0){
            end = end.next;
            n--;
        }

        while (end.next!=null){
            end = end.next;
            start = start.next;
        }

        //删除倒数第n个元素
        start.next = start.next.next;

        return dummyHead.next;
    }

}
