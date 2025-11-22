package DSA.Assiagnment.StackAndQueue;

public class QueueLinkedList {


        // Node structure
        private class Node {
            int data;
            Node next;
            Node(int data) {
                this.data = data;
            }
        }

        private Node front; // first element
        private Node rear;  // last element

        // ENQUEUE operation
        public void enqueue(int value) {
            Node newNode = new Node(value);

            if (rear == null) {          // first element
                front = rear = newNode;
                return;
            }

            rear.next = newNode;
            rear = newNode;
        }

        // DEQUEUE operation
        public int dequeue() {
            if (front == null) {
                throw new RuntimeException("Queue Underflow");
            }

            int val = front.data;
            front = front.next;

            if (front == null)   // after deletion queue becomes empty
                rear = null;

            return val;
        }

        // PEEK operation
        public int peek() {
            if (front == null) {
                throw new RuntimeException("Queue is Empty");
            }
            return front.data;
        }

        public boolean isEmpty() {
            return front == null;
        }

    public static void main(String[] args) {
        QueueLinkedList ql=new QueueLinkedList();
        ql.enqueue(20);
        ql.enqueue(30);
        ql.enqueue(40);
        ql.enqueue(50);
        System.out.println(ql.dequeue());
    }

    }


