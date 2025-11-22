package DSA.Assiagnment.CircularQueue;

public class DequeUsingDLL {
    private static class Node {
        int val;
        Node prev, next;
        Node(int v) { val = v; }
    }

    private Node head, tail;
    private int size;

    public DequeUsingDLL() { size = 0; }

    public void addFirst(int x) {
        Node node = new Node(x);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void addLast(int x) {
        Node node = new Node(x);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public Integer removeFirst() {
        if (head == null) return null;
        int v = head.val;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
        return v;
    }

    public Integer removeLast() {
        if (tail == null) return null;
        int v = tail.val;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
        size--;
        return v;
    }

    public Integer peekFirst() {
        return head == null ? null : head.val;
    }

    public Integer peekLast() {
        return tail == null ? null : tail.val;
    }

    public boolean isEmpty() { return size == 0; }

    public static void main(String[] args) {
        DequeUsingDLL dq = new DequeUsingDLL();
        dq.addFirst(10);
        dq.addLast(20);
        dq.addFirst(5);
        System.out.println("PeekFirst: " + dq.peekFirst()); // 5
        System.out.println("PeekLast: " + dq.peekLast());   // 20
        System.out.println("RemoveFirst: " + dq.removeFirst()); //5
        System.out.println("RemoveLast: " + dq.removeLast());   //20
    }
    }

