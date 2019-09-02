package SwordingToOffer;

import java.util.Hashtable;

/**
 * 利用hashtable和双向链表进行实现。记录链表可容纳个数和处理完毕个数。
 * 若相应的key存在hashtable中，则将该节点移动到头节点的next节点，不存在则添加至头节点的next节点，
 * 超过则淘汰链表尾部的节点。
 */
class DLinkedNode {
    int key;
    String value;
    DLinkedNode pre;
    DLinkedNode next;
}

public class HandMakeLRU {
    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode> ();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    //初始化
    public HandMakeLRU(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        head = new DLinkedNode ();
        head.pre = null;
        tail = new DLinkedNode ();
        tail.next = null;
        head.next = tail;
        tail.pre = head;
    }

    public String get(int key) {
        DLinkedNode node = cache.get (key);
        if (node == null) {
            return null;
        }
        this.moveToHead (node);
        return node.value;
    }

    public void set(int key, String value) {
        DLinkedNode node = cache.get (key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode ();
            newNode.key = key;
            newNode.value = value;
            this.cache.put (key, newNode);
            this.addNode (newNode);
            ++count;
            if (count > capacity) {
                DLinkedNode tail = this.popTail ();
                this.cache.remove (tail.key);
                --count;
            }
        } else {
            node.value = value;
            this.moveToHead (node);
        }
    }

    //添加节点
    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    //移除节点
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    //更新最近节点
    private void moveToHead(DLinkedNode node) {
        this.removeNode (node);
        this.addNode (node);
    }

    //淘汰最早节点
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode (res);
        return res;
    }

    public static void main(String[] args) {
        HandMakeLRU s = new HandMakeLRU (3);
//        int i=-6>>2;
//        System.out.println(i);
        s.set (1, "1");
        s.set (2, "2");
        s.set (3, "3");
        s.set (4, "4");
        String param_1 = s.get (4);
        String param_2 = s.get (3);
        String param_3 = s.get (2);
        String param_4 = s.get (1);
        s.set (5, "5");
        String param_5 = s.get (1);
        String param_6 = s.get (2);
        String param_7 = s.get (3);
        String param_8 = s.get (4);
        String param_9 = s.get (5);
        System.out.println (param_1);
        System.out.println (param_2);
        System.out.println (param_3);
        System.out.println (param_4);
        System.out.println (param_5);
        System.out.println (param_6);
        System.out.println (param_7);
        System.out.println (param_8);
        System.out.println (param_9);


    }

}
