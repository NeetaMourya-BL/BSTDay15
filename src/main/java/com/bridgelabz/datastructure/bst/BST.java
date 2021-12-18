package com.bridgelabz.datastructure.bst;
public class BST{ 
    //node class that defines BST node
    class Node { 
        int key; 
        Node left, right; 
   
        public Node(int data){ 
            key = data; 
            left = right = null; 
        } 
    } 
    // BST root node 
    Node root; 
  
   // Constructor for BST =>initial empty tree
    BST(){ 
        root = null; 
    } 
    int minValue(Node root)  { 
        //initially minval = root
        int minval = root.key; 
        //find minval
        while (root.left != null)  { 
            minval = root.left.key; 
            root = root.left; 
        } 
        return minval; 
    } 
   
    // insert a node in BST 
    void insert(int key)  { 
        root = insert_Recursive(root, key); 
    } 
   
    //recursive insert function
    Node insert_Recursive(Node root, int key) { 
          //tree is empty
        if (root == null) { 
            root = new Node(key); 
            return root; 
        } 
        //traverse the tree
        if (key < root.key)     //insert in the left subtree
            root.left = insert_Recursive(root.left, key); 
        else if (key > root.key)    //insert in the right subtree
            root.right = insert_Recursive(root.right, key); 
          // return pointer
        return root; 
    } 
 
// method for inorder traversal of BST 
    void inorder() { 
        inorder_Recursive(root); 
    } 
   
    // recursively traverse the BST  
    void inorder_Recursive(Node root) { 
        if (root != null) { 
            inorder_Recursive(root.left); 
            System.out.print(root.key + " "); 
            inorder_Recursive(root.right); 
        } 
    } 
     
    //recursive insert function
    Node search_Recursive(Node root, int key)  { 
        // Base Cases: root is null or key is present at root 
        if (root==null || root.key==key) 
            return root; 
        // val is greater than root's key 
        if (root.key > key) 
            return search_Recursive(root.left, key); 
        // val is less than root's key 
        return search_Recursive(root.right, key); 
    } 
    boolean search(int key)  { 
        root = search_Recursive(root, key); 
        if (root!= null)
            return true;
        else
            return false;
    } 
}
class Main{
    public static void main(String[] args)  { 
        //insert data into BST
    	BST bst=new BST();
        bst.insert(56); 
        bst.insert(30); 
        bst.insert(22); 
        bst.insert(40); 
        bst.insert(11); 
        bst.insert(3); 
        bst.insert(16); 
        bst.insert(70); 
        bst.insert(60); 
        bst.insert(95); 
        bst.insert(65); 
        bst.insert(63); 
        bst.insert(67); 
        //print the BST
        System.out.println("The BST Created with input data(Left-root-right):"); 
        bst.inorder(); 
        //search a key in the BST
        boolean ret_val = bst.search (63);
        System.out.println("\nKey 63 found in BST:" + ret_val );
     } 
}