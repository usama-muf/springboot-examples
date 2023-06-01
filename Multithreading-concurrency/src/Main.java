import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        System.out.println("Main Thread Running!");

//        Extending Thread Class
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Using lambda " + Thread.currentThread() + " : " + i);
            }
        }, "Thread_1");
//        thread.setDaemon(true);

//        thread1.start();


//        Implementing Runnable Interface
        Thread thread2 = new Thread(new Thread3Runnable());
//        thread2.start();


//        Thread3Runnable runnable = new Thread3Runnable();
//        runnable.defaultMehtod();

//        Examples from Tutorials

        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Foo " + name);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar " + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        runnable.run();

        Thread thread = new Thread(runnable);
        thread.start();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.submit(() -> {
//            try {
//                String name = Thread.currentThread().getName();
//                System.out.println("Foo " + name);
//                TimeUnit.SECONDS.sleep(1);
//                System.out.println("Bar " + name);
//            }
//            catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            finally {
//                if(!executorService.isTerminated()) {
//                    System.out.println("Shutdown initiated");
//                }
//                executorService.shutdown();
//                System.out.println("Shutdown completed");
//            }
//        });


//        Example of Callable (which is a functional Interface but it return a value)

        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                for (int i = 0; i < 2; i++)
                    TimeUnit.SECONDS.sleep(1);
                return 123;
            } catch (InterruptedException e) {
                throw new InterruptedException();
            }

        };

//        Using get method of future.
        ExecutorService executorService1 = Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService1.submit(task);
//        System.out.println("Future is done? "+future.isDone());
////        executorService1.shutdownNow();
//        System.out.println(future.get(5, TimeUnit.SECONDS));
//        System.out.println(future.isDone());
//        System.out.println(future.get());


//        Using executeAll method of future.

        Callable<String> task1 = () -> {
            try {
                long time = Math.round(Math.random() * 10 + 1);
                TimeUnit.SECONDS.sleep(time);
                System.out.println("Taking " + time + " seconds");
                return "Task 1";
            } catch (InterruptedException e) {
                throw new InterruptedException();
            }

        };
        Callable<String> task2 = () -> {
            try {
                long time = Math.round(Math.random() * 10 + 1);
                TimeUnit.SECONDS.sleep(time);
                System.out.println("Taking " + time + " seconds");
                return "Task 2";
            } catch (InterruptedException e) {
                throw new InterruptedException();
            }

        };
        Callable<String> task3 = () -> {
            try {
                long time = Math.round(Math.random() * 10 + 1);
                TimeUnit.SECONDS.sleep(time);
                System.out.println("Taking " + time + " seconds");
                return "Task 3";
            } catch (InterruptedException e) {
                throw new InterruptedException();
            }

        };

        ExecutorService executorService2 = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(task1, task2, task3);

        System.out.println(executorService2.invokeAny(callables));

//        executorService2.invokeAll(callables).stream().map(stringFuture -> {
//            try {
//                return stringFuture.get();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            } catch (ExecutionException e) {
//                throw new RuntimeException(e);
//            }
//        }).forEach(System.out::println);
//
//        System.out.println(callables);


//        Using Schedule Executor Service

        ScheduledExecutorService executorService3 = Executors.newScheduledThreadPool(1);
        Runnable taskRunnable1 = () -> System.out.println("Scheduling : " + System.nanoTime());

        ScheduledFuture scheduledFuture = executorService3.scheduleAtFixedRate(taskRunnable1, 0, 1, TimeUnit.SECONDS);
//                executorService3.schedule(taskRunnable1, 3 , TimeUnit.SECONDS);


        System.out.println(scheduledFuture);
        System.out.println(scheduledFuture.getDelay(TimeUnit.MICROSECONDS));


        System.out.println("Main Thread End !");
    }

}
