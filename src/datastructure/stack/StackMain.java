package datastructure.stack;

public class StackMain {

    public static void main(String[] args) {
        // Custom Stack

        // Creating an instance of CustomStack
//        CustomStack datastructure.stack = new CustomStack();
//
//        // Testing push method
//        datastructure.stack.push(5);
//        datastructure.stack.push(10);
//        datastructure.stack.push(15);
//
//        // Testing pop method
//        System.out.println("Popped element: " + datastructure.stack.pop());
//
//        // Testing peek method
//        System.out.println("Peeked element: " + datastructure.stack.peek());
//
//        // Testing pop and peek on an empty datastructure.stack
//        CustomStack emptyStack = new CustomStack();
//        System.out.println("Popped element from empty datastructure.stack: " + emptyStack.pop());
//        System.out.println("Peeked element from empty datastructure.stack: " + emptyStack.peek());



        // Dynamic Stack main ----------

        // Creating an instance of DynamicStack
        DynamicStack stack = new DynamicStack();

        // Testing push method
        stack.push(5);
        stack.push(10);
        stack.push(15);

        // Testing pop method
        System.out.println("Popped element: " + stack.pop());

        // Testing peek method
        System.out.println("Peeked element: " + stack.peek());

        // Testing pop and peek on an empty datastructure.stack
        DynamicStack emptyStack = new DynamicStack();
        System.out.println("Popped element from empty datastructure.stack: " + emptyStack.pop());
        System.out.println("Peeked element from empty datastructure.stack: " + emptyStack.peek());

        // Testing push more elements to check auto-growth
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }

        // Testing pop all elements
        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }
    }

}
