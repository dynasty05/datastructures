package test.java.com.thirtytwotwenty;

import main.java.com.thirtytwotwenty.ArrayStack;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by ribake on 20/12/2017.
 */
public class TestArrayStack {
    @Test
    public void shouldPushOneElementIntoEmptyStack(){
        // arrange
        ArrayStack as = new ArrayStack();

        // act
        as.push(5);

        // assert
        assertEquals(5, as.peek());
        assertEquals(1, as.size());

    }

    @Test
    public void shouldReturnLastElementWhenSeveralElementsAdded(){
        // arrange
        ArrayStack as = new ArrayStack();

        // act
        as.push(5);
        as.push(19);
        as.push(25);
        as.push(77);

        // assert
        assertEquals(77, as.peek());
        assertEquals(4, as.size());

    }

    @Test
    public void shouldReturnEmptyStackAfrerOnlyElementIsRemoved(){
        // arrange
        ArrayStack as = new ArrayStack();

        // act
        as.push(5);
        int result = as.pop();

        // assert
        assertEquals(5, result);
        assertEquals(0, as.size());

    }
}
