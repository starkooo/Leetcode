package com.ncepu;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 */

/**
 * 对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点head。
 * 使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
 */
public class Sol_02 {


      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next;}

          public void add(int index,int val){

          }
     }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //这里定义一个pre是为了后面返回结果简便，因为pre不会移动，最后直接返回即可
        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        int carry = 0;
        while (l1 != null || l2 != null){
            int x = l1==null ? 0 : l1.val;
            int y = l2==null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum/10;
            sum = sum%10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (carry==1){
            cur.next = new ListNode(1);
        }
        return pre.next;
    }
}
