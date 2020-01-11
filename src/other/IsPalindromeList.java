package other;

import java.util.Stack;

public class IsPalindromeList {

    // 给定两个链表，判断两个列表的内容是否为回文

    public static class Node{
        public int value;
        public Node next;

        public Node(int data){
            this.value = data;
        }
    }


    // 方法1：先全部压入栈，再依次弹出和链表每个元素比较

    public static boolean isPalindromeList(Node head){
        Stack<Node> stack = new Stack<>();

        Node cur = head;

        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        while (head != null){
            if (head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // 方法2：只需要在栈中储存 n/2 的链表大小

    public static boolean isPalindromeList2(Node head){
        if (head == null || head.next == null){
            return true;
        }
        // 链表必有2个节点以上
        Node slow = head.next; // 慢
        Node fast = head; // 快
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // while结束后，目标是slow来到右半区的第一个
        Stack<Node> stack = new Stack<>();
        while (slow != null){
            stack.push(slow);
            slow = slow.next;
        }
        while (!stack.isEmpty()){
            if (head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // 方法3：使用快慢指针，把中点后的链表逆序，时间复杂度为O(N)，空间复杂度为O(N)，记得最后要把逆序的后半部分改成原来的顺序

    public static boolean isPalindromeList3(Node head){
        if (head == null || head.next == null){
            return true;
        }

        Node n1 = head; // 慢
        Node n2 = head; // 快
        while (n2.next != null && n2.next.next != null){ // find mid node
            n1 = n1.next; // n1 -> mid
            n2 = n2.next.next; // n2 -> end
        }
        // n1 -> 1
        n2 = n1.next; // n2 -> right part first node
        n1.next = null; // mid.next -> null
        Node n3 = null;
        while(n2 != null){ // right part convert
            n3 = n2.next; // n3 -> save next code
            n2.next = n1; // next of right node convert
            n1 = n2; // n1 move
            n2 = n3; // n2 move
        }

        n3 = n1; // n3 -> save last node
        n2 = head; // n2 -> left last node
        boolean res = true;
        while (n1 != null && n2 != null){ // check palindrome
            if (n1.value != n2.value){
                res = false;
                break;
            }
            n1 = n1.next; // right to mid
            n2 = n2.next; // left to mid
        }
        n1 = n3.next;
        n3.next = null;
        while(n1 != null){ // recover list
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return  res;
    }
}
