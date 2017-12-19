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

    @Test
    public void shouldReturnFalseForEmptyTree(){
        // arrange
        BinarySearchTree bst = new BinarySearchTree();

        // act
        boolean result = bst.find(50, bst.getRootNode());

        // assert
        assertFalse(result);
    }

    @Test
    public void shouldReturnTrueIfNodeExistsInTree(){
        // arrange
        BinarySearchTree bst = new BinarySearchTree();
        // root node is set after first insertion
        Node n1 = new Node(100);
        Node n2 = new Node(90);
        Node n3 = new Node(200);
        Node n4 = new Node(85);

        bst.insert(n1, bst.getRootNode());
        Node root = bst.getRootNode();
        bst.insert(n2, root);
        bst.insert(n3, root);
        bst.insert(n4, root);


        // act
        boolean result = bst.find(85, root);

        // assert
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseIfNodeDoesNotExistInTree(){
        // arrange
        BinarySearchTree bst = new BinarySearchTree();
        // root node is set after first insertion
        Node n1 = new Node(100);
        Node n2 = new Node(90);
        Node n3 = new Node(200);
        Node n4 = new Node(85);

        bst.insert(n1, bst.getRootNode());
        Node root = bst.getRootNode();
        bst.insert(n2, root);
        bst.insert(n3, root);
        bst.insert(n4, root);


        // act
        boolean result = bst.find(300, root);

        // assert
        assertFalse(result);
    }

    @Test
    public void shouldReturnNullMinNodeForEmptyTree(){
        // arrange
        BinarySearchTree bst = new BinarySearchTree();

        // act
        Node min = bst.findMinimum(bst.getRootNode());

        // assert
        assertNull(min);

    }

    @Test
    public void shouldReturnRootNodeAsMinimumForTreeWithSingleNode(){
        // arrange
        BinarySearchTree bst = new BinarySearchTree();

        // act
        bst.insert(new Node(10), bst.getRootNode());
        Node min = bst.findMinimum(bst.getRootNode());

        // assert
        assertEquals(10, min.getData());
    }

    @Test
    public void shouldReturnCorrectMinimumNodeInNonEmptyTree(){
        // arrange
        BinarySearchTree bst = new BinarySearchTree();
        Node root = bst.insert(new Node(100), bst.getRootNode());
        Node min = new Node(5);
        bst.insert(new Node(90), root);
        bst.insert(new Node(200), root);
        bst.insert(new Node(85), root);
        bst.insert(new Node(95), root);
        bst.insert(new Node(250), root);
        bst.insert(min, root);

        //act
        Node result = bst.findMinimum(root);

        // assert
        assertEquals(min.getData(), result.getData());
    }

    @Test
    public void shouldReturnNullMaxNodeForEmptyTree(){
        // arrange
        BinarySearchTree bst = new BinarySearchTree();

        // act
        Node max = bst.findMaximum(bst.getRootNode());

        // assert
        assertNull(max);

    }

    @Test
    public void shouldReturnRootNodeAsMaximumForTreeWithSingleNode(){
        // arrange
        BinarySearchTree bst = new BinarySearchTree();

        // act
        bst.insert(new Node(10), bst.getRootNode());
        Node max = bst.findMaximum(bst.getRootNode());

        // assert
        assertEquals(10, max.getData());
    }

    @Test
    public void shouldReturnCorrectMaximumNodeInNonEmptyTree(){
        // arrange
        BinarySearchTree bst = new BinarySearchTree();
        Node root = bst.insert(new Node(100), bst.getRootNode());
        Node max = new Node(250);
        bst.insert(new Node(90), root);
        bst.insert(new Node(200), root);
        bst.insert(new Node(85), root);
        bst.insert(new Node(95), root);
        bst.insert(max, root);
        bst.insert(new Node(5), root);

        //act
        Node result = bst.findMaximum(root);

        // assert
        assertEquals(max.getData(), result.getData());
    }

}
