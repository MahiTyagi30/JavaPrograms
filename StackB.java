
import java.util.*;

public class StackB {
    static class stack{
        static ArrayList<Integer> list=new ArrayList<>();
        public static Boolean isEmpty(){
            return (list.size()==0);
        }
        public static void push(int data){
            list.add(data);
        }
        public static int pop(){
            if(isEmpty()==true){
                return -1;
            }
            int top=list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        public static int peek(){
            if(isEmpty()==true){
                return -1;
            }
            return list.get(list.size()-1);
        }
    }
    public static void main(String[] args){
        Stack<Integer> s=new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()){

            System.out.println(s.peek());
            s.pop();
        }

    }
    
}
