package synchronization;

import java.util.concurrent.CopyOnWriteArrayList;

public class Stack {
    private int[] array;
//    private CopyOnWriteArrayList<Integer> al;
    private int stackTop;
    Object lock;

    Stack(int capacity) {
        stackTop = -1;
        array = new int[capacity];
        lock = new Object();
//        al = new CopyOnWriteArrayList<>();
    }

    public synchronized boolean push(int value) {
        if(isFull()) return false;

            ++stackTop;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            array[stackTop] = value;
            return true;

    }

    public int pop() {
        if(isEmpty()) return Integer.MIN_VALUE;
        synchronized (this){
            int obj = array[stackTop];
            array[stackTop] = Integer.MIN_VALUE;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            stackTop--;
            return obj;
        }
    }

    private boolean isFull() {
        return stackTop>= array.length-1;
    }
    private boolean isEmpty() {
        return stackTop<0;
    }


}
