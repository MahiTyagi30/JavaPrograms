import java.util.Scanner;

import javax.xml.crypto.NodeSetData;

public class LinkedList {

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {

        Node newNode = new Node(data);// creating new node
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;

    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print() {
        if (head == null) {
            System.out.println("ll s empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "--> ");
            temp = temp.next;
        }
        System.out.println("null");

    }

    public void add(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if (size == 0) {
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        // prev:i=size-2;
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int itrSearch(int key) {// O(n)
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {// key found case
                return i;
            }
            temp = temp.next;
            i++;

        }
        return -1;// key not found
    }

    public int helper(int key, Node head) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(key, head.next);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int recSearch(int key) {
        return helper(key, head);
    }

    public void reverseList() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void findNthNode(int n) {
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        if (sz == n) {
            head = head.next;
            return;
        }
        int i = 1;
        Node prev = head;
        while (i < (sz - n)) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    // slow fast approach
    public Node findMid(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;// slow is your mid
    }

    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        // step 1: find mid
        Node midNode = findMid(head);

        // step 2:reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // step 3:check left and right part
        Node right = prev;
        Node left = head;
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static boolean isCycle() {
        Node f = head;
        Node s = head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
            if (s == f) {
                return true;
            }
        }
        return false;
    }

    public static void removeCycle() {
        // detect the cycle
        boolean cycle = false;
        Node f = head;
        Node s = head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
            if (s == f) {
                cycle = true;
                break;
            }
        }
        // find the meeting point again
        s = head;
        Node prev = null;
        while (s != f) {
            prev = f;
            f = f.next;
            s = s.next;
        }

        // removing the cycle

        prev.next = null;

    }

    private Node getMid(Node head) {
        Node fast = head;
        Node slow = head.next;// to get 1st half last node
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }

    private Node merge(Node h1, Node h2) {
        Node ll = new Node(-1);
        Node temp = ll;
        while (h1 != null && h2 != null) {
            if (h1.data <= h2.data) {
                temp.next = h1;
                h1 = h1.next;
                temp = temp.next;

            } else {
                temp.next = h2;
                h2 = h2.next;
                temp = temp.next;

            }

        }
        while (h1 != null) {
            temp.next = h1;
            h1 = h1.next;
            temp = temp.next;
        }
        while (h2 != null) {
            temp.next = h2;
            h2 = h2.next;
            temp = temp.next;

        }
        return ll.next;
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        return merge(newLeft, newRight);

    }

    public void zigzag() {
        // find the mid
        Node fast = head.next;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        Node mid = slow;
        // reverse the 2nd hafl
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // alternate zig zag
        Node leftH = head;
        Node rightH = prev;
        Node nextL;
        Node nextR;
        while (leftH != null && rightH != null) {
            nextL = leftH.next;
            leftH.next = rightH;
            nextR = rightH.next;
            rightH.next = nextL;
            nextL = leftH;
            nextR = rightH;

        }

    }
    public void removeNodes(int m,int n){
        Node curr=head,t;
        int count;
        while(curr!=null){
            for(count=1;count<m&&curr!=null;count++){
                curr=curr.next;
            }
            if(curr==null){
                return;
            }
            t=curr.next;
            for(count=1;count<=n&&curr!=null;count++){
                Node temp=t;
                t=t.next;
            }
            curr.next=t;
            curr=t;
        }
        int i=1;
        Node temp=head;
        while(i<=m){
            temp=temp.next;
            i++;
        }
        temp.next=temp.next.next.next;
    }
    public void swapNodes(Node k1,Node k2){
        int pos1=0;
        int pos2=0;
        
        int i=1;
        Node curr=head;
        while(curr!=null){
            if(curr==k1){
                pos1=i;
                int a;
            }
            else if(curr==k2){
                pos2=i;
                int b=curr.data;
            }
            curr=curr.next;
            i++;
        }
        int count =1;
        Node t=head;
        while(t!=null){
            if(count==pos1){
                Node temp=t;
                t=a;
            }
            else if(count==pos2){
                Node temp=t;
                
                t=a;
            }
            t=t.next;
            count++;

        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addFirst(20);
        ll.print();
       // ll.removeNodes(3,2);
       ll.swapNodes(2, 5);
        ll.print();
        // System.out.println(ll.checkPalindrome());
        // ll.print();

    }

}
