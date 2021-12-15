package com.pratice.LinkedList;

import java.util.HashMap;

public class LRUCache {

    public class Node{
        private int key;
        private int val;
        private Node pre;
        private Node next;

        public Node(){}

        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }

    private Node dummyHead = new Node();
    private Node dummyTail = new Node();
    private int capacity;
    private int size;

    private HashMap<Integer,Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    private void add(Node node){
        Node originHead = dummyHead.next;
        dummyHead.next = node;
        node.pre = dummyHead;
        node.next = originHead;
        originHead.pre = node;
    }

    private void del(Node node){
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
        //这里不用size--，因为del是为了add，这个缓存中删除节点不会直接删除，也就是说size只有++或不变
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node==null){
            return -1;
        }
        del(node);
        add(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node==null){
            if (size<capacity){
                size++;
            }else {
                Node delNode = dummyTail.pre;
                del(delNode);
                map.remove(delNode.key);
            }
            Node newNode = new Node(key,value);
            add(newNode);
            map.put(key,newNode);
        }else {
            node.val = value;
            del(node);
            add(node);
        }
    }
}
