package DSA.Assiagnment.StackAndQueue;

public class QueueArray {
      int []  queue;
      int toq;
      int boq;
      QueueArray(int size){
          queue=new int [size];
          toq=boq=-1;
      }

      boolean isEmpty(){
          return toq==-1||boq==queue.length-1;
      }
      boolean isFull(){
          return toq==queue.length-1;
      }

      void enQueue(int value){
          if(isFull())
              System.out.println("the Queue is fill");
          else if(boq==-1){
              boq=0;
              queue[++toq]=value;
              System.out.println("the value add successfully");
          }
          else{
              queue[++toq]=value;
              System.out.println("the value add successfully");
          }

      }

      void deQueue(){
          if(isEmpty())
              System.out.println("the Queue is empty");
          else {
              int no =queue[boq];
              boq++;
              if(boq>toq)
                  boq=toq=-1;
              System.out.println("the remove valuere is "+no);

          }
      }
      void peek(){
          if(isEmpty()){
              System.out.println("the queue is empty");
          }
          else {
              System.out.println("the top most element is "+queue[boq]);
          }
      }

    public static void main(String[] args) {
        QueueArray arr=new QueueArray(5);
        arr.enQueue(20);
        arr.enQueue(50);
        arr.enQueue(80);
        arr.deQueue();
        arr.peek();
    }
}
