package main.java.com.thirtytwotwenty;

/**
 * Created by ribake on 19/12/2017.
 * A node in the binary tree.
 * Integer data assumed in node.
 */
public class Node {
    private int data;
    private Node leftChild;
    private Node rightChild;

    public Node(int data){
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
