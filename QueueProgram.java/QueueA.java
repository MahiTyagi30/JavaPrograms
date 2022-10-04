public class QueueA {
    static class Queue{
        static int ar[];
        static int size;
        static int rear;
        static int front;
        Queue(int n){
            int ar[]=new int[n];
            size=n;
            rear=-1;
            front =-1;
        }
        public static boolean isEmpty(){
            return rear==-1&&front==-1;
        }
        public static boolean isFull(){
            if((rear+1)%size==front){
                return true;
            }
            else{
                return false;
            }
        }
        public static void add(int data){
            if(isFull()){
                System.out.println("queue is full");
                return;
            }
            if(front==-1){
                front=0;
            }
            rear=(rear+1)%size;
            ar[rear]=data;
        }
        public static int remove(){//o(n)
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            int res=ar[front];
           if(front==rear){//only one element is left
            front=rear=-1;
           }
           else{
            front=(front+1)%size;
           }
           return res;
        }
        public static int peek(){

            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            return ar[front];
        }

    }
    public static void main(String[] args){
        Queue q=new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
    
}
