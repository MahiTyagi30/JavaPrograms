import java.util.*;
import java.util.LinkedList;
public class QueueB {
    static class Stackk{
        static Queue<Integer> q1=new LinkedList<>();
        static Queue<Integer> q2=new LinkedList<>();
        public static boolean isEmpty(){
            return q1.isEmpty()&&q2.isEmpty();
        }
        public static void add(int data){
            if(!q1.isEmpty()){
                q1.add(data);
            }
            else{
                q2.add(data);
            }
        }
        public static int pop(){
            if(isEmpty()){
                System.out.println("empty stack");
                return -1;
            }
            int top=-1;
            //case 1:
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top=q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }

            }
            //cse:2
            else{
                if(!q1.isEmpty()){
                    while(!q2.isEmpty()){
                        top=q2.remove();
                        if(q2.isEmpty()){
                            break;
                        }
                        q1.add(top);
                    }
    
                }

            }

        
        return top;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("empty stack");
                return -1;
            }
            int top=-1;
            //case 1:
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top=q1.remove();
                    
                    q2.add(top);
                }

            }
            //cse:2
            else{
                if(!q1.isEmpty()){
                    while(!q2.isEmpty()){
                        top=q2.remove();
                        
                        q1.add(top);
                    }
    
                }

            }
            return top;

        }
    }
    static class Queuee{
        static Stack<Integer> s1=new Stack<>();
       static  Stack<Integer> s2=new Stack<>();
        public static boolean isEmpty(){
            return s1.isEmpty();   
        }
        public static void add(int data){// O(n)
            if(s1.isEmpty()){
                s1.push(data);
            }
            else{
                while(!s1.isEmpty()){
                    s2.push(s1.peek());
                    s1.pop();
                }
                s1.push(data);
                while(!s2.isEmpty()){
                    s1.push(s2.peek());
                    s2.pop();
                }
            }
        }
        public static int remove(){
            if(s1.isEmpty()){
                System.out.println("empty stack");
                return -1;
            }
            return s1.pop();
        }
        public static int peek(){
            if(s1.isEmpty()){
                return -1;
            }
            return s1.peek();
        }
    }

    public static void main(String[] args){
        Stackk s=new Stackk();
        s.add(1);
        s.add(2);
        s.add(3);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
        // Queuee q=new Queuee();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // while(!q.isEmpty()){
        //     System.out.println(q.peek());
        //     q.remove();
        // }
    }
    
}
