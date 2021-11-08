package com.ncepu;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *  
 * 示例 1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 *
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 * 思路：先把区间内链表截断，再反转，然后将剩下的元素接上反转后链表
 */


public class Sol_92 {


    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        //获得left前一个元素
        ListNode pre = dummyHead;
        for (int i = 0; i < left-1; i++) {
            //走left-1步到
            pre = pre.next;
        }

        //获得right节点
        ListNode rightNode = pre;
        for (int i = 0; i < right-left+1; i++) {
            //从pre走right-left+1步到
            rightNode = rightNode.next;
        }

        //获得left节点
        ListNode leftNode = pre.next;
        //获得right后接的第一个元素
        ListNode tmp = rightNode.next;

        //断开连接
        pre.next = null;
        rightNode.next = null;

        //将区间内链表反转
        reverseLinkedList(leftNode);

        //接回反转后链表
        pre.next = rightNode;
        leftNode.next = tmp;

        return dummyHead.next;
    }

    private void reverseLinkedList(ListNode head){
         ListNode pre = null;
         ListNode cur = head;

         while (cur!=null){
             ListNode tmp = cur.next;
             cur.next = pre;
             pre = cur;
             cur = tmp;
         }
    }

}
