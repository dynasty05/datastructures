package test.java.com.thirtytwotwenty;

import main.java.com.thirtytwotwenty.BinarySearchTree;
import main.java.com.thirtytwotwenty.Node;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by ribake on 19/12/2017.
 */
public class TestBinarySearchTree {
    @Test
    public void shouldReturnZeroNodesForEmptyTree(){
        BinarySearchTree bst = new BinarySearchTree();
        Assert.assertEquals(0, bst.size());
    }

    @Test
    public void shouldReturnNodeReferenceWhenNodeInsertedInEmptyTree(){
        // arrange
        BinarySearchTree bst = new BinarySearchTree();
        Node root = bst.getRootNode();
        Node n = new Node(100);

        // act
        bst.insert(n, root);

        // assert
        // n should be new root
        assertEquals(n, bst.getRootNode());
        assertEquals(1, bst.size());
    }

    @Test
    public void shouldAddNodeInLeftSubTreeForNodeLessThanRoot(){
        // arrange
        BinarySearchTree bst = new BinarySearchTree();
        // root node is 100
        Node n1 = new Node(100);
        bst.insert(n1, bst.getRootNode());

        // act - add node 90
        Node n2 = new Node(90);
        bst.insert(n2, bst.getRootNode());

        // assert
        assertEquals(n2, bst.getRootNode().getLeftChild());
        assertEquals(2, bst.size());

    }

    @Test
    public void shouldAddNodeInRightSubTreeForNodeGreaterThanRoot(){
        // arrange
        BinarySearchTree bst = new BinarySearchTree();
        // root node is 100
        Node n1 = new Node(100);
        bst.insert(n1, bst.getRootNode());

        // act - add node 200
        Node n2 = new Node(200);
        bst.insert(n2, bst.getRootNode());

        // assert
        assertEquals(n2, bst.getRootNode().getRightChild());
        assertEquals(2, bst.size());

    }

    @Test
    public void shouldInsertNodeInLeftSubtreeForNodeEqualToRootNode(){
        // arrange
        BinarySearchTree bst = new BinarySearchTree();
        // root node is 100
        Node n1 = new Node(100);
        bst.insert(n1, bst.getRootNode());

        // act - add node 100
        Node n2 = new Node(100);
        bst.insert(n2, bst.getRootNode());

        // assert
        assertEquals(n2, bst.getRootNode().getLeftChild());
        assertEquals(2, bst.size());

    }

    @Test
    public void shouldInsertNodeInLeftSubtreePositionForLeastNode(){
        // arrange
        BinarySearchTree bst = new BinarySearchTree();
        // root node is 100
        Node n1 = new Node(100);
        Node n2 = new Node(90);
        bst.insert(n1, bst.getRootNode());
        bst.insert(new Node(200), bst.getRootNode());
        bst.insert(n2, bst.getRootNode());

        // act - add node 80
        Node n3 = new Node(80);
        bst.insert(n3, bst.getRootNode());

        // assert
        assertEquals(n3, n2.getLeftChild());
        assertEquals(4, bst.size());

    }

    @Test
    public void shouldInsertNodeInRightSubtreePositionForGreatestNode(){
        // arrange
        BinarySearchTree bst = new BinarySearchTree();
        // root node is 100
        Node n1 = new Node(100);
        Node n2 = new Node(90);
        Node n3 = new Node(200);
        bst.insert(n1, bst.getRootNode());
        bst.insert(n2, bst.getRootNode());
        bst.insert(n3, bst.getRootNode());

        // act - add node 300
        Node n4 = new Node(400);
        bst.insert(n4, bst.getRootNode());

        // assert
        assertEquals(n4, n3.getRightChild());
        assertEquals(4, bst.size());

    }
}
