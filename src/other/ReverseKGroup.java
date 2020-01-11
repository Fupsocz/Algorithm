package other;

public class ReverseKGroup {

    /*
    给定一个单链表的头节点 head,实现一个调整单链表的函数，使得每K个节点之间为一组进行逆序，
    并且从链表的尾部开始组起，头部剩余节点数量不够一组的不需要逆序。
    （不能使用队列或者栈作为辅助）

    例如：
    链表:1->2->3->4->5->6->7->8->null, K = 3。那么 6->7->8，3->4->5，1->2各位一组。
    调整后：1->2->5->4->3->8->7->6->null。
    其中 1，2不调整，因为不够一组
     */

    class ListNode{
        int value;
        ListNode next;
        public ListNode(int value){
            this.value = value;
        }
    }

    public static ListNode solve(ListNode head, int k){
        if (head == null || head.next == null){
            return head;
        }

        reverseList(head);
        head = reverKGroup(head, k);
        return reverseList(head);
    }

    public static ListNode reverKGroup(ListNode head, int k){
        ListNode temp = head;
        for(int i = 1; i < k && temp.next != null; i++){
            temp = temp.next;
        }
        if (temp == null){
            return head;
        }

        ListNode node = temp.next;
        temp.next = null;

        ListNode newHead = reverseList(head);
        ListNode newTemp = reverKGroup(node, k);

        head.next = newTemp;
        return newHead;
    }

    public static ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
