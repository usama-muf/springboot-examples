package producer_consumer_problem;

public class Main {
    public static void main(String[] args) {
        BlockingQueue q = new BlockingQueue(5);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(q.add(i*i));
                try {
                    Thread.sleep((int)(Math.random()*1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(q.remove());
                try {
                    Thread.sleep((int)(Math.random()*1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();

//        new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                q.add(i);
//            }
//        }).start();
//        new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                q.remove();
//            }
//        }).start();




//        Thread t3 = new Thread(() -> {
//            try {
//                Thread.sleep(1);
//                for (int i = 0; i <10000; i++);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        t3.start();
//
//        while(true) {
//            Thread.State state = t3.getState();
//            System.out.println(state);
//            if(state == Thread.State.TERMINATED) break;
//        }


    }
}
