package DSA.Assiagnment;



class Node2{
    public int value;
    public Node2 next;
}

public class CircularLinkedLsit {
    public Node2 head, tail;
    public int size;

    public void creationOfCSL(int value) {
        head = new Node2();
        Node2 node = new Node2();
        node.value = value;
        node.next = node;
        head = tail = node;
        size = 1;
    }

    public void insertion(int location, int value) {
        Node2 node = new Node2();
        node.value = value;
        if (head == null) {
            creationOfCSL(value);
        } else if (location == 0) {
            node.next = head;
            head = node;
            tail.next=head;
        }
        else {
            node.next = head;
            tail.next = node;
            tail = node;
        }
    }
    public void forwardTraverse() {
        System.out.println("******************forwardTraverse**********************");

        Node2 temp = head;
        while (temp != null) {
            for(int i=0;i<25;i++)
            {
                System.out.print(temp.value + " ");
                temp = temp.next;
            }
            break;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedLsit cs= new CircularLinkedLsit();
        cs.creationOfCSL(20);
        cs.insertion(0, 30);
        cs.insertion(1, 40);
        cs.insertion(2, 50);
        cs.insertion(3, 60);
        cs.insertion(4, 70);
//		cs.creationOfCSL(60);
//		cs.insertion(0, 1);
        cs.forwardTraverse();
    }

}

