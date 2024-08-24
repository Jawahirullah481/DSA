package datastructure.heap.dsa;

import java.util.ArrayList;

public class Heap {
    private ArrayList<Integer> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    private int left(int index) {
        return (2 * index) + 1;
    }

    private int right(int index) {
        return (2 * index) + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int i1, int i2) {
        int temp = heap.get(i1);
        heap.set(i1, heap.get(i2));
        heap.set(i2, temp);
    }

    public void insert(int num) {
        heap.add(num);

        if(heap.size() == 1) {
            return;
        }

        upHeap(heap.size() - 1);
    }

    private void upHeap(int child) {
        if(child <= 0) {
            return;
        }

        int parent = parent(child);
        if(heap.get(child) < heap.get(parent)) {
            swap(child, parent);
            upHeap(parent);
        }

    }

    public void print() {
        System.out.println(heap);
    }

    public int remove() {
        if(heap.size() == 0) {
            return -1;
        }

        int value = heap.remove(0);
        if(heap.size() == 0) {
            return value;
        }
        int lastValue = heap.remove(heap.size() - 1);
        heap.add(0, lastValue);
        downHeap(0);

        return value;
    }

    private void downHeap(int index) {
        if(heap.size() == 0 || heap.size() == 1) {
            return;
        }

        int min = index;
        int left = left(index);
        int right = right(index);

        // By the below 2 if conditions, i can find the min of min, left and right
        if(left < heap.size() && heap.get(left) < heap.get(min)) {
            min = left;
        }
        if(right < heap.size() && heap.get(right) < heap.get(min)) {
            min = right;
        }

        if(min != index) {
            swap(min, index);
            downHeap(min);
        }

    }

    private int minValue(int index1, int index2) {
        if(index1 >= heap.size() && index2 >=heap.size()) {
            return -1;
        }

        if(index1 >= heap.size()) {
            return index2;
        }
        if(index2 >= heap.size()) {
            return index1;
        }

        int value1 = heap.get(index1);
        int value2 = heap.get(index2);

        return value1 < value2 ? index1 : index2;
    }


    public static void main(String[] args) {
        Heap heap = new Heap();
        for(int i = 10; i > 0; i--) {
            heap.insert(i);
        }
        int i = 0;
        while((i = heap.remove()) != -1) {
            System.out.print(i + " ");
        }
    }
}