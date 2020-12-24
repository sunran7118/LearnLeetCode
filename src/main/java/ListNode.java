public class ListNode {
    public int val;
    public ListNode next;   // 下一个链表对象
    public ListNode(int x) { val = x; }  //赋值链表的值

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
