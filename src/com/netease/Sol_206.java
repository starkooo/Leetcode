package com.netease;

import java.util.List;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *  
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 *
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 */

public class Sol_206 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //记得画图
    public ListNode reverseList(ListNode head) {
        //记录当前节点的前一个节点
        ListNode pre = null;
        //当前节点
        ListNode cur = head;

        while (cur!=null){
            //因为链表是单向的，为了防止链表断开，丢失后续节点，所以在断开之前用一个tmp来保存后续节点
            ListNode tmp = cur.next;
            //实现反转，就是把当前节点指向上一个节点
            cur.next = pre;
            //然后pre和cur向前移动
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
