package com.ncepu;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Sol_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });

        //将k个链表的头节点添加到堆中
        for (ListNode head:lists){
            if (head!=null){
                pq.add(head);
            }
        }
        while (!pq.isEmpty()){
            //获取最小节点并从pq中取出
            ListNode small = pq.poll();

            p.next = small;

            //如果上面取出的节点还有后续节点，把它后面的节点继续扔到pq内，进行排序(因为堆中存的是各链表的头节点)
            if (small.next!=null){
                pq.add(small.next);
            }
            p = p.next;
        }
        return dummy.next;
    }
}
