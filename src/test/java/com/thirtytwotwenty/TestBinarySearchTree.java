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
        Node n = new Node(100);
        Node root = bst.getRootNode();

        // act
        bst.insert(n, root);

        // assert
        // n should be new root
        assertEquals(n, bst.getRootNode());
        assertEquals(1, bst.size());
    }


}
