package datastructure.stack;

public class CustomStack {

    protected int[] stack;
    public static final int DEFAULT_SIZE = 5;
    protected int top;

    public CustomStack() {
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        stack = new int[size];
        top = 0;
    }

    public boolean push(int value) {
        if(isFull()) {
            return false;
        }
        stack[top++] = value;
        return true;
    }

    public int pop() {
        if(isEmpty()) {
            return -1;
        }
        return stack[--top];
    }

    public int peek() {
        if(isEmpty()) {
            return -1;
        }
        return stack[top - 1];
    }

    public boolean isFull() {
        return top == stack.length;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void display() {
        for(int i = top; i > 0; i--) {
            System.out.print(stack[i - 1] + " -> ");
        }
    }

}
