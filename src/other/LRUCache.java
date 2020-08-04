package other;

import other.LRUCache.DLinkNode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DLinkNode{
        int key;
        int val;
        DLinkNode pre;
        DLinkNode post;
    }

    private void addNode(DLinkNode node){
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    private void removeNode(DLinkNode node){
        DLinkNode pre = node.pre;
        DLinkNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    private void moveToHead(DLinkNode node){
        this.removeNode(node);
        this.addNode(node);
    }

    private DLinkNode popTail(){
        DLinkNode pre = tail.pre;
        this.removeNode(pre);
        return pre;
    }

    private Map<Integer, DLinkNode> cache = new HashMap<>();
    private int count;
    private int capacity;
    private DLinkNode head, tail;

    public LRUCache(int capacity){
        this.count = 0;
        this.capacity = capacity;

        DLinkNode head = new DLinkNode();
        head.pre = null;

        DLinkNode tail = new DLinkNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key){
        DLinkNode node = cache.get(key);
        if (node == null) return -1;

        this.moveToHead(node);
        return node.val;
    }

    public void put(int key, int val){
        DLinkNode node = cache.get(key);

        if (node == null){
            DLinkNode newNode = new DLinkNode();

            newNode.key = key;
            newNode.val = val;

            this.addNode(newNode);
            cache.put(key, newNode);
            ++count;

            if (count > capacity){
                DLinkNode removeNode = this.popTail();
                cache.remove(removeNode.key);
                --count;
            }

        } else {
            this.moveToHead(node);
            capacity++;
        }
    }
}
