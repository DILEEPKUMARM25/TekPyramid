package DSA.Assiagnment.StackAndQueue;

public class statckArray {

    int[] stack;
   int tos;
    statckArray(int size){
       stack = new int[size];
       tos=-1;
    }
boolean  isEmpty(){
       return tos==-1;
    }
    boolean  isFull(){
        return tos==stack.length-1;
    }
    void push(int value){
        if(isFull()){
            System.out.println("Stack is full");
        }
        else {
            stack[++tos]=value;
            System.out.println("Pushed "+value+" to stack");
        }

    }

void pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        }
        else  {
            int value=stack[tos];
            System.out.println("Popped "+value+" from stack");
      tos--;
        }
}

void peek(){
        if(isEmpty()){
        System.out.println("Stack is empty");
        }
        else   {
            int value=stack[tos];
            System.out.println("Popped "+value+" from stack");
        }
}

void poll(){
        if(isEmpty()){
        System.out.println("Stack is empty");
        }
        else{
            int value=stack[tos];
            System.out.println("Popped "+value+" from stack");
            tos--;
        }
}

void delete(){
    if(isEmpty()){
        System.out.println("Stack is empty");
    }
    else {
        stack=null;
    }
}

    public static void main(String[] args) {

        statckArray obj = new statckArray(5);
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.pop();
        obj.poll();
        obj.peek();




    }
}
