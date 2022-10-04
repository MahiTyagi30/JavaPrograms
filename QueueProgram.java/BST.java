import java.security.spec.EdDSAParameterSpec;
import java.util.*;
public class BST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    public static Node buildTree(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(val<root.data){
            root.left=buildTree(root.left, val);
        }
        if(val>root.data){
            root.right=buildTree(root.right, val);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(root.data>key){
            return search(root.left, key);
        }
        else{
            return search(root.right, key);
        }
    }

    public static Node inorderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static Node delete(Node root,int val){
        if(root.data<val){
            root.right=delete(root.right, val);
        }
        if(root.data<val){
            root.left=delete(root.left, val);
        }
        else{
            //case 1: no child
            if(root.left==null&&root.right==null){
                return null;
            }
            //case 2:single child
            if(root.left==null){
                return root.right;
            }
           else if(root.right==null){
                return root.left;
            }
            //case 3:both child
            Node IS=inorderSuccessor(root.right);
            root.data=IS.data;
            root.right=delete(root.right, IS.data);

        }
        return root;
    }
    public static void printInRange(Node root,int k1,int k2){
        if(root==null){
            return;
        }
        if(root.data>=k1&&root.data<=k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data<k1){
        printInRange(root.left, k1, k2);
        }
        else{
            printInRange(root.right, k1, k2);
        }
    }
    public static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+" ");
        }
        System.out.println();
    }
    public static void printRoot2Path(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root);     
        if(root.left==null&&root.right==null){
            printPath(path);
        }
        printRoot2Path(root.left, path);
        printRoot2Path(root.right, path);
        path.remove(path.size()-1);
    }
    public static boolean isValidBST(Node root,Node min,Node max){
        if(root==null){
            return true;
        }
        if(min!=null&&root.data<=min.data){
            return false;

        }
        else if(max!=null&&root.data>=max.data){
            return false;
        }
        return isValidBST(root.left, min, root)&&isValidBST(root.right, root, max);
    }
    public static Node mirrorBST(Node root){
        if(root==null){
            return null;
        }
        Node leftS=mirrorBST(root.left);
        Node rightS=mirrorBST(root.right);
        root.left=rightS;
        root.right=leftS;
        return root;
    }
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static Node createBST(int ar[],int st,int end){
        if(st>end){
            return null;
        }
        
        int mid=(st+end)/2;
        Node root=new Node(ar[mid]);
        root.left=createBST(ar, st, mid-1);
        root.right=createBST(ar, mid+1, end);
        return root;
    }
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;
        public Info(boolean isBST,int size,int min,int max){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
        }

    }

    public static int BST=0;
    public static Info largestBst(Node root){
        if(root==null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info lefInfo=largestBst(root.left);
        Info rightInfo=largestBst(root.right);
        int size=lefInfo.size+rightInfo.size+1;
        int min=Math.min(root.data,Math.min(lefInfo.min,rightInfo.min));
        int max=Math.max(root.data,Math.max(lefInfo.max,rightInfo.max));

        if(root.data<=lefInfo.max ||root.data>=rightInfo.max){
            return new Info(false,size,min,max);
        }    
        if(lefInfo.isBST&&rightInfo.isBST){
            BST=Math.max(BST, size);
          return  new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }
    public static void getInorder(Node root,ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }
    public static Node createBSTfrom2bst(ArrayList<Integer> ar,int st,int end){
        if(st>end){
            return null;
        }
        
        int mid=(st+end)/2;
        Node root=new Node(ar.get(mid));
        root.left=createBSTfrom2bst(ar, st, mid-1);
        root.right=createBSTfrom2bst(ar, mid+1, end);
        return root;
    }
    public static Node mergeBst(Node root1,Node root2){
        ArrayList<Integer> arr1=new ArrayList<>();
        getInorder(root1, arr1);
        ArrayList<Integer> arr2=new ArrayList<>();
        getInorder(root2, arr2);
        int i=0;int j=0;
        ArrayList<Integer> finalarr=new ArrayList<>();
        while(i<arr1.size()&&j<arr2.size()){
            if(arr1.get(i)<=arr2.get(j)){
                finalarr.add(arr1.get(i));
                i++;
            }
            else{
                finalarr.add(arr2.get(i));
                j++;
            }
        }   
        while(i<arr1.size()){
            finalarr.add(arr1.get(i));
            i++;

        }
        while(j<arr2.size()){
            finalarr.add(arr2.get(j));
            j++;
        }
       return  createBSTfrom2bst(finalarr, 0, finalarr.size()-1);
    
    }
    static int max=Integer.MAX_VALUE;
    static Node a;
    public static Node closestNode( Node root,int k){
        if(root==null){
            return null;
        }
       if(root.data>k){
        closestNode(root.left, k);
       }
       else{
        closestNode(root.right, k);
       }
       if(max>Math.abs(root.data-k)){
        max=root.data-k;
        a=root;
       }
  return a;
    }
      public static void kthSmallestElement(Node root,int k){
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null){
            return ;
        }
        getInorder(root,list);
        int a=list.size()-k;
        System.out.println("the smallest elsement is"+list.get(a));
        //return;
        
      }
      static int sum=0;
      public static int rangeSumBst(Node root ,int l,int h){
        if(root==null){
            return 0;
        }
        if(l<=root.data&&root.data<=h){

            return root.data+ rangeSumBst(root.left, l, h)+rangeSumBst(root.right, l, h);
        }
       else if(root.data<l){
            return rangeSumBst(root.right, l, h);
        }
        else{
            return rangeSumBst(root.left, l, h);
        }
        

      }
    public static void main(String[] args){
    //     int value[]={8,5,3,1,4,6,10,11,14};
    //     Node root=null;
    //     for(int i=0;i<value.length;i++){
    //         root=buildTree(root, value[i]);
    // //     }
        Node root1=new Node(8);
       root1.left=new Node(5);
       root1.right=new Node(11);
       root1.left.left=new Node(3);
       root1.left.right=new Node(6);
       root1.right.right=new Node(20);
    //    root1=mirrorBST(root1);
   // System.out.println(closestNode(root1, 19).data);
  // kthSmallestElement(root1, 3);
  System.out.println(rangeSumBst(root1, 5, 11));
   
    
    // Node root1=new Node(2);
    // root1.left=new Node(1);
    // root1.right=new Node(4);

    // Node root2=new Node(9);
    // root2.left=new Node(3);
    // root2.right=new Node(12);
    // Node root=mergeBst(root1, root2);
    // preorder(root);

        //inorder(root);
      //  System.out.println();
      // root= delete(root, 10);
      // inorder(root);
     // ArrayList<Integer> path=new ArrayList<>();
     //  printInRange(root, 5, 12);
       //printRoot2Path(root, path);
      // System.out.println(isValidBST(root, null, null));
    }
    
}
