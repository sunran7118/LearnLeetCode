public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;node2.next = node3;node3.next = node4;node4.next = node5;
        System.out.println(swapPairs(node1));
        /*System.out.println(node1);System.out.println(node2);System.out.println(node3);
        System.out.println(node4);System.out.println(node5);
        reverseList(node1);
        System.out.println(node1);System.out.println(node2);System.out.println(node3);
        System.out.println(node4);System.out.println(node5);
        reverse(node5);
        System.out.println(node1);System.out.println(node2);System.out.println(node3);
        System.out.println(node4);System.out.println(node5);*/
    }
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
    public static ListNode swapPairs1(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }


    public static ListNode reverseList(ListNode head) {
        //申请节点，pre和 cur，pre指向null
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur!=null) {
            //记录当前节点的下一个节点
            next = cur.next;
            //然后将当前节点指向pre
            cur.next = pre;
            //pre和cur节点都前进一位
            pre = cur;
            cur = next;
        }
        return pre;
    }
    /**递归的方法其实是非常巧的，它利用递归走到链表的末端，然后再更新每一个node的next 值 (代码倒数第二句)。
     * 在下面的代码中， reverseRest 的值没有改变，为该链表的最后一个node，所以，反转后，我们可以得到新链表的head。*/
    public static ListNode reverse(ListNode current) {
        if (current == null || current.next == null){
            return current;
        }
        ListNode nextNode = current.next;
        current.next = null;
        ListNode reverseRest = reverse(nextNode);
        nextNode.next = current;
        return reverseRest;
    }
}

