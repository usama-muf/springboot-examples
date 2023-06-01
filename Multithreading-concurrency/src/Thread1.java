public class Thread1 extends Thread{

    @Override
    public void run() {
        for(int i=0; i<5; i++) {

            System.out.println("Thread1 running "+i);
        }

        Thread thread = new Thread2();
//        thread.setDaemon(true);
        thread.start();

    }

}
