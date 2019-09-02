package SwordingToOffer;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode (int label) {
        this.label = label;
    }
}

public class ComplexListNode {
    public static RandomListNode Clone (RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode curNode = pHead;
        //1、复制每个结点，如复制结点A得到A'，将结点A'插到结点A后面
        while (curNode != null) {
            RandomListNode cloneNode = new RandomListNode (curNode.label);
            cloneNode.next = curNode.next;
//            RandomListNode nextNode=cloneNode.next;
            curNode.next = cloneNode;
//            cloneNode.next=nextNode;
            curNode = cloneNode.next;
        }
        curNode = pHead;
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A'.random = A.random.next(由于插在后面)
        while (curNode != null) {
            curNode.next.random = curNode.random == null ? null : curNode.random.next;
            curNode = curNode.next.next;
        }//3、拆分链表，将链表拆分为原链表和复制后的链表
        curNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (curNode != null) {
            RandomListNode cloneNode = curNode.next;
            curNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            curNode = curNode.next;
        }
        return pCloneHead;
    }

    public static void printList (RandomListNode head) {
        while (head != null) {
            System.out.print (head.label + "->");
            head = head.next;
        }
        System.out.println ("null");
    }

    public static void main (String[] args) {
        //          -----------------
        //         \|/              |
        //  1-------2-------3-------4-------5
        //  |       |      /|\             /|\
        //  --------+--------               |
        //          -------------------------
        RandomListNode head = new RandomListNode (1);
        head.next = new RandomListNode (2);
        head.next.next = new RandomListNode (3);
        head.next.next.next = new RandomListNode (4);
        head.next.next.next.next = new RandomListNode (5);

        head.random = head.next.next;
        head.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next;

        RandomListNode tmp = head;
        printList (tmp);
        RandomListNode newHead = Clone (head);
        printList (newHead);
    }
}
