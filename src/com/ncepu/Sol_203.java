package com.ncepu;

public class Sol_203 {

    public class ListNode{
        int val;
        ListNode next;
        public ListNode(){}
        public ListNode(ListNode next,int val){
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return head;
        }

        ListNode dummyHead = new ListNode(head,-1);
        ListNode pre = dummyHead;
        ListNode cur = head;
        while (cur!=null){
            if (cur.val == val){
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
