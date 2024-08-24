package datastructure.queue.dsa;

public class DynamicQueue extends CustomQueue {

    @Override
    public boolean add(int value) {
        if(isFull()) {
            int[] temp = new int[queue.length * 2];
            for(int i = 0; i < size; i++) {
                temp[i] = queue[(first + i) % queue.length];
                // index = y % size
                // y = size + x. where x is how much y is greater than size
                // index = (size + x) % size
                // 0     = (5    + 0) % 5
                // 1     = (5    + 1) % 5
                // 2     = (5    + 2) % 5
            }
            queue = temp;
            first = 0;
            last = size;
        }
        return super.add(value);
    }
}
