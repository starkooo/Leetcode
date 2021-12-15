package com.pratice.LinkedList;

public class Sol707 {

    int size;
    ListNode dummy;

    public Sol707() {
        size = 0;
        dummy = new ListNode(-1);
    }

    public int get(int index) {
        if (index<0 || index>=size){
            return -1;
        }
        ListNode cur = dummy;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        if (index>size){
            return;
        }
        if (index<0){
            index = 0;
        }
        size++;
        //先找到要插入位置的前驱
        ListNode pre = dummy;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = pre.next;
        pre.next = newNode;
    }

    public void deleteAtIndex(int index) {
        if (index<0 || index>=size){
            return;
        }
        size--;
        //先要找到待删除元素的前驱节点
        ListNode pre = dummy;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
    }
}
