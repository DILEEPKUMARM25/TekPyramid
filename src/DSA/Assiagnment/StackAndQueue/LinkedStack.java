package DSA.Assiagnment.StackAndQueue;

public class LinkedStack {
        // Node structure
        private class Node {
            int data;
            Node next;
            Node(int data) {
                this.data = data;
            }
        }

        private Node top;  // top of stack

        // PUSH operation
        public void push(int value) {
            Node newNode = new Node(value);
            newNode.next = top;
            top = newNode;
        }

        // POP operation
        public int pop() {
            if (top == null) {
                throw new RuntimeException("Stack Underflow");
            }
            int val = top.data;
            top = top.next;
            return val;
        }

        // PEEK operation
        public int peek() {
            if (top == null) {
                throw new RuntimeException("Stack is Empty");
            }
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }


    public static void main(String[] args) {
        LinkedStack ar=new LinkedStack();
        ar.push(20);
        ar.push(30);
        ar.push(40);
        System.out.println(  ar.pop());
    }
    }


