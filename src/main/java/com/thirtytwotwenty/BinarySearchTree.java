package main.java.com.thirtytwotwenty;

/**
 * Created by ribake on 19/12/2017.
 * Java implementation of Binary Search Tree.
 */
public class BinarySearchTree {
    private Node root;
    private int size = 0;

    public int size(){
        return this.size;
    }

//    public int size(){
//        int s = 0;
//        if (root == null) {
//            s = 0;
//
//        } else {
//            // recursively count size of left and right subtree
//            s = treeSize(root);
//        }
//
//        return s;
//    }

    //TODO: figure out how to traverse tree without double-counting nodes
    private int treeSize(Node n){
        int s = 0;
        // base condition
        if(n.getLeftChild() == null){
            s++;
        }
        if(n.getRightChild() == null){
            s++;
        }

        if(n.getLeftChild() != null){
            s++;
            treeSize(n.getLeftChild());
        }

        if (n.getRightChild() != null){
            s++;
            treeSize(n.getRightChild());
        }

        return s;
    }

    public Node getRootNode(){
        return root;
    }

    /**
     * Insert a node into the appropriate position of a
     * binary tree or subtree with a given root .
     * @param n node to be inserted
     * @param root root of the subtree
     * @return reference to the newly inserted node -
     * i.e; the new left or right child
     */
    public Node insert(Node n, Node root) {
        Node theNode = null;

        // base condition
        if (root == null){ // for empty tree
            theNode = this.root = n;
            size++;
            return theNode;

        } else if (n.getData() <= root.getData() && root.getLeftChild() == null){
            root.setLeftChild(n);
            size++;
            theNode = n;
            return theNode;

        } else if (n.getData() > root.getData() && root.getRightChild() == null){
            root.setRightChild(n);
            size++;
            theNode = n;
            return theNode;

        } else if (n.getData() <= root.getData()){
            // recursively insert into left sub-tree
            root = root.getLeftChild();
            insert(n, root);

        } else { // recursively insert into right sub-tree
            root = root.getRightChild();
            insert(n, root);
        }

        return n;
    }
}
