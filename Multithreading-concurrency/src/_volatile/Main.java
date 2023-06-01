package _volatile;

public class Main {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                TvSet tvSet = TvSet.getTvSetInstance();
                System.out.println(tvSet);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                TvSet tvSet = TvSet.getTvSetInstance();
                System.out.println(tvSet);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        t1.start();
        t2.start();
//        TvSet tvSet1 = TvSet.getTvSetInstance();
//        System.out.println(tvSet1);
    }
}
