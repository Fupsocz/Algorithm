package sort;

import java.util.Scanner;

public class Exam {

    public static class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        Node node = new Node(in.nextInt());
        Node head = node;
        for (int i = 1; i <= n - 1; i++){
            node.next = new Node(in.nextInt());
            node = node.next;
        }
        int k = in.nextInt();
        if(k >= n){
            System.out.println("k must be smaller than n");
            return;
        }

        Node node1 = head;
        Node node2 = head;

        int i = 0;
        while(i < k){
            node2 = node2.next;
            i++;
        }

        while(node2 != null){
            node2 = node2.next;
            node1 = node1.next;
        }

        System.out.println("The required Node is :" + node1.value);
    }
}