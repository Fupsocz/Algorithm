package other;

import java.util.HashMap;

public class LeastRecentlyUsedCache {

    /**
     * 设计LRU缓存结构
     */

    public static class Node<V>{
        public V value;
        public Node<V> last;
        public Node<V> next;

        public Node(V value){
            this.value = value;
        }
    }

    public static class NodeDoubleLinkedList<V>{
        private Node<V> head;
        private Node<V> tail;

        public NodeDoubleLinkedList(){
            this.head = null;
            this.tail = null;
        }

        public void addNewNode(Node<V> newNode){
            if (newNode == null){
                return;
            }
            if (head == null){   // 双向链表一个节点也没有
                this.head = newNode;
                this.tail = newNode;
            }else {   // 双向链表有节点
                this.tail.next = newNode;
                newNode.last = tail;
                this.tail = newNode;
            }
        }

        // node一定在双向链表上
        public void moveNodeToTail(Node<V> node){
            if (this.tail == node){
                return;
            }
            if (this.head == node){  // node是头部
                this.head = node.next;
                this.head.last = null;
            } else { // node不是头部
                node.last.next = node.next;
                node.next.last = node.last;
            }
            node.last = this.tail;
            node.next = null;
            this.tail.next = node;
            this.tail = node;
        }

        public Node<V> removeHead(){
            if (this.head == null){
                return null;
            }
            Node<V> res = this.head;
            if (this.head == this.tail){
                this.head = null;
                this.tail = null;
            }else {
                this.head = res.next;
                res.next = null;
                this.head.last = null;
            }
            return res;
        }

    }

    public static class MyCahce<K,V>{
        private HashMap<K, Node<V>> keyNodeMap;
        private HashMap<Node<V>, K> nodeKeyMap;
        private NodeDoubleLinkedList<V> nodeList;
        private int capacity;

        public MyCahce(int capacity){
            if (capacity < 1){
                throw new RuntimeException("capacity should be more than 0");
            }
            this.keyNodeMap = new HashMap<>();
            this.nodeKeyMap = new HashMap<>();
            this.nodeList = new NodeDoubleLinkedList<>();
            this.capacity = capacity;
        }

        public V get(K key){
            if (this.keyNodeMap.containsKey(key)){
                Node<V> res = this.keyNodeMap.get(key);
                this.nodeList.moveNodeToTail(res);
                return res.value;
            }
            return null;
        }

        public void set(K key, V value){
            if (this.keyNodeMap.containsKey(key)){
                Node<V> node = this.keyNodeMap.get(key);
                node.value = value;
                this.nodeList.moveNodeToTail(node);
            }else{
                Node<V> newNode = new Node<>(value);
                this.keyNodeMap.put(key, newNode);
                this.nodeKeyMap.put(newNode, key);
                this.nodeList.addNewNode(newNode);
                if (this.keyNodeMap.size() == this.capacity + 1){
                    removeMostUnusedCache();
                }
            }
        }

        private void removeMostUnusedCache(){
            Node<V> removeNode = nodeList.removeHead();
            K removeKey = nodeKeyMap.get(removeNode);
            nodeKeyMap.remove(removeNode);
            keyNodeMap.remove(removeKey);
        }
    }
}
