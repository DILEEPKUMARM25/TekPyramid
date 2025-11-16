package DSA.Assiagnment;

public class SingleLinkedList {
    public static void main(String[] args) {
        SingleLinkeList sll = new SingleLinkeList();
        sll.creationOfSLL(10);
        sll.insertion(1, 20);
        sll.insertion(4, 30);
        sll.insertion(3, 40);
        sll.insertion(2, 50);

//		sll.forwardTraverse();
        sll.searching(30);
        sll.searching(3);
//		sll.deletion();
        sll.forwardTraverse();
        sll.backwardTraverse();
    }
}




class Node {
    public int value;
    public Node next;
}

class SingleLinkeList {
    public Node head, tail;
    public int size;

    public void creationOfSLL(int value) {// 20
        head = new Node();
        Node node = new Node();
        node.value = value;
        node.next = null;
        head = tail = node;
        size = 1;
    }
    public void insertion(int location, int value) {// 0 20
        Node node = new Node();
        node.value = value;
        if (head == null) {
            creationOfSLL(value);
        } else if (location == 0) {// insertion @ 1st
            node.next = head;
            head = node;
        } else { // insertion @ last
            node.next = null;
            tail.next = node;
            tail = node;
        }
    }






    public void forwardTraverse() {
        System.out.println("******************forwardTraverse**********************");

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    public void backwardTraverse() {

        System.out.println("******************backwardTraverse**********************");

        Node pre=null,mid=null,current=head;

        while(current!=null)
        {
            pre=mid;
            mid=current;
            current=current.next;
            mid.next=pre;
        }


        while ( mid!= null) {
            System.out.print(mid.value + " ");
            mid = mid.next;
        }
        System.out.println();
    }

    public void searching(int searchValue) {
        System.out.println("******************Search -"+searchValue +"**********************");
        Node temp = head;
        while (temp != null) {
            if (temp.value == searchValue) {
                System.out.println("The value is present");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Value is not present");
    }




    public void deletion() {
        head = tail = null;
        System.out.println("List is deleted");
    }
}

