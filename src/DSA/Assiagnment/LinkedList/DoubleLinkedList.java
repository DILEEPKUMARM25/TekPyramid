package DSA.Assiagnment.LinkedList;



class Node1
{
    Node1 pre;
    int value;
    Node1 next;
}

class List{
    Node1 head,tail;
    int size;
    void creation(int value)
    {
        head= new Node1();
        Node1 node=new Node1();
        node.next=null;
        node.pre=head ;
        node.value=value;
        head=tail=node;
        size=1;
        System.out.println(head);

    }
    void insertion(int loc , int value) {
        Node1 node = new Node1();
        node.value = value;
        if (head == null)
        {
            creation(value);
        }
        else if(loc==0) {
            node.next=head;
            node.pre=null;
            head.pre=node;
            head=node;

        }
        else {
            node.next=null;
            node.pre=tail;
            tail.next=node;
            tail=node;
        }
    }


    public void forwardTraverse() {
        System.out.println("******************forwardTraverse**********************");

        Node1 temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public void searching(int searchValue) {
        System.out.println("******************Search -"+searchValue +"**********************");
        Node1 temp = head;
        while (temp != null) {
            if (temp.value == searchValue) {
                System.out.println("The value is present");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Value is not present");
    }



}

public class DoubleLinkedList {
    public static void main(String[] args) {
        List a=new List();
        a.creation(10);
        a.insertion(0, 20);
        a.insertion(1, 30);
        a.insertion(2, 40);
        a.insertion(3, 50);
        a.forwardTraverse();
        a.searching(60);
    }

}
