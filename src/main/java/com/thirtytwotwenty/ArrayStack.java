package main.java.com.thirtytwotwenty;

/**
 * Created by ribake on 20/12/2017.
 * Array implementation of Stack ADT.
 * Based on ints.
 */
public class ArrayStack {
    int top = -1;
    int[] elements = new int[10];

    /**
     * Push an element into this array
     * if possible.
     * @param i
     */
    public void push(int i){
        if(top < elements.length){
            top++;
            elements[top] = i;
        }
    }

    /**
     * Return but not remove the topmost
     * element.
     * @return
     */
    public int peek(){
        return elements[top];
    }

    /**
     * Return the current size of this array.
     * @return
     */
    public int size() {
        return top + 1;
    }

    /**
     * Returns and removes the top most element
     * in this array.
     * @return
     */
    public int pop(){
        int out = elements[top];
        elements[top] = 0;
        top--;

        return out;
    }
}
