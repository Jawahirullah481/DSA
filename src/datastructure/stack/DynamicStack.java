package datastructure.stack;

public class DynamicStack extends CustomStack {

    public DynamicStack() {
        super();
    }

    public DynamicStack(int size) {
        super(size);
    }

    @Override
    public boolean push(int value) {
        if(isFull()) {
            int[] tempStack = new int[stack.length * 2];
            for(int i = 0; i < stack.length; i++) {
                tempStack[i] = stack[i];
            }
            stack = tempStack;
        }
        return super.push(value);
    }
}
