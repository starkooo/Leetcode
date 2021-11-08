package com.ncepu;

public class Sol_24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;

        while (cur.next!=null && cur.next.next!=null){

            ListNode temp = cur.next;
            ListNode temp2 = cur.next.next.next;

            cur.next = cur.next.next;
            cur.next.next = temp;
            cur.next.next.next = temp2;

            cur = cur.next.next;
        }
        return dummyHead.next;
    }
}
