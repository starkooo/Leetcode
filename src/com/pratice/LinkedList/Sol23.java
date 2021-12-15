package com.pratice.LinkedList;

import java.util.PriorityQueue;

public class Sol23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        PriorityQueue<ListNode> ascQueue = new PriorityQueue<>(
                lists.length,(a,b)->(a.val-b.val)
        );

        for (ListNode node:lists){
            if (node!=null){
                ascQueue.add(node);
            }
        }

        while (!ascQueue.isEmpty()){
            ListNode small = ascQueue.poll();
            p.next = small;
            if (small.next!=null){
                ascQueue.add(small.next);
            }
            p = p.next;
        }
        return dummy.next;
    }
}
