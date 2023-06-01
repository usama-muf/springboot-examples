package producer_consumer_problem;

public class BlockingQueue_s {
    int[] queue;
    int index ;

    BlockingQueue_s(int capacity) {
        queue = new int[capacity];
        index=-1;
    }

    public synchronized boolean push(int value) {
        if(isFull()) return false;

        ++index;
        queue[index]=value;
        return true;


    }

    public synchronized int pop() {
        if (isEmpty()) return Integer.MIN_VALUE;

        return queue[index--];
    }

    private boolean isFull() {
        if(index>=queue.length) return true;
        return false;
    }

    private boolean isEmpty() {
        if(index<0) return true;
        return false;
    }
}
