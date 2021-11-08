package com.ncepu;

import java.util.HashMap;

/**
 * leetcode 146
 */
public class LRUCache {

    private class Node{
        private int key;
        private int value;
        private Node pre;
        private Node next;
        public Node(){

        }
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    private Node dummyHead = new Node();
    private Node dummyTail = new Node();
    private int capacity;
    private int size;

    private HashMap<Integer,Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
        this.capacity = capacity;
        size = 0;
    }

    //删除某个节点
    private void del(Node node){
        Node preNode = node.pre;
        Node nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
        node.pre = null;
        node.next = null;
    }

    //将节点添加到dummyHead后面
    //添加都放到链表最前
    private void add(Node node){
        Node originHead = dummyHead.next;
        dummyHead.next = node;
        node.pre = dummyHead;
        node.next = originHead;
        originHead.pre = node;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node==null){
            return -1;
        }
        //不为空，则该节点刚被访问过，要放到链表的最前
        del(node);
        add(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        //如果key对应的node已经存在了，则代表node刚被访问过，要把node放到最前面
        if (node!=null){
            //先更新的value
            node.value = value;
            del(node);
            add(node);
        }else {
            //key对应的node还没存在，要先判断链表是否已满
            //未满，直接size++，再添加节点
            if (size<capacity){
                size++;
            }else {
                //已满，把链表最后一个节点删除
                Node delNode = dummyTail.pre;
                map.remove(delNode.key);
                del(delNode);
            }
            Node newNode = new Node(key,value);
            add(newNode);
            map.put(key,newNode);
        }
    }
}
