package datastructure.queue.dsa;

public class CustomQueue {

    protected int[] queue;
    protected static final int DEFAULT_SIZE = 5;
    protected int first;
    protected int last;
    protected int size;

    public CustomQueue() {
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        queue = new int[size];
        first = 0;
        last = 0;
        size = 0;
    }

    public boolean add(int value) {
        if(isFull()) {
            return false;
        }
        queue[last++] = value;
        last = last % queue.length;
        size++;
        return true;
    }

    public int delete() {
        if(isEmpty()) {
            return -1;
        }
        size--;
        int removed = queue[first++];
        first = first % queue.length;
        return queue[first++];
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        int i = first;
        do {
            System.out.println(queue[i] + " <- ");
            i++;
            i = i % queue.length;
        } while(i != last);
    }

}
