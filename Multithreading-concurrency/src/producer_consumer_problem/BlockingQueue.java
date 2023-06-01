package producer_consumer_problem;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    private Queue<Integer> queue;
    private int capacity;

    BlockingQueue(int cap) {
        queue = new LinkedList<>();
        this.capacity = cap;
    }
    public boolean add(int value) {
        synchronized (queue){
            while (queue.size() == capacity) {
                try {
                    System.out.println("ADD :: Waiting for queue to free one space.");
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            queue.add(value);
            queue.notifyAll();
            return true;
        }
    }
    public  int remove() {
        synchronized (queue){
            while (queue.size() == 0) {
                // what if this block of code first got the chance to execute &&
                // what if the queue is empty
                //then it will wait for a condition when the size of queue is not zero

                try {
                    System.out.println("REMOVE :: Waiting for an element to add ");
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int item = queue.poll();
            queue.notifyAll();
            return item;
        }
    }




}
