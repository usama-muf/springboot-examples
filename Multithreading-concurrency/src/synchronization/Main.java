package synchronization;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        long time = new Date().getTime();
        Stack stack = new Stack(5);
        new Thread(() -> {
            int counter = 0;
            while(++ counter < 10) {
                System.out.println("Pushing Element "+ stack.push(100));
            }
        }, "pusher").start();

        new Thread(() -> {
            int counter = 0;
            while(++ counter < 10) {
                System.out.println("Popping Element "+ stack.pop());
            }
        }, "Popper").start();


//        Stack stack = new Stack(10);
//        stack.push(12);
//        System.out.println(stack.pop());
//        System.out.println("Total Time : "+ (new Date().getTime() - time));
    }
}
