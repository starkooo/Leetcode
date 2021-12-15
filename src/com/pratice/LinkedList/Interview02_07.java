package com.pratice.LinkedList;

public class Interview02_07 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;

        int lenA = 0;
        int lenB = 0;

        while (curA!=null){
            lenA++;
            curA = curA.next;
        }
        while (curB!=null){
            lenB++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;

        if (lenA<lenB){
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;

            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }

        int gap = lenA - lenB;
        while (gap>0){
            curA = curA.next;
            gap--;
        }

        while (curA!=null){
            if (curA==curB){
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
