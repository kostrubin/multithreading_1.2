import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        getResultFromAll();
        getResultFromAny();
    }

    private static void getResultFromAll() {
        System.out.println("\nGetting results from all threads...");

        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Future<String>> futureList = new ArrayList<>();
        Callable<String> callable = new MyCallable();

        try {

            for (int i = 0; i < 4; i++) {
                Future<String> future = executor.submit(callable);
                futureList.add(future);
            }

            for (Future<String> future : futureList) {
                System.out.println(future.get());
            }

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        System.out.println("...All results have been received");
    }

    private static void getResultFromAny() {
        System.out.println("\nGetting results from any thread...");

        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<MyCallable> taskList = new ArrayList<>();
        String res = "";

        for (int i = 0; i < 4; i++) {
            MyCallable task = new MyCallable();
            taskList.add(task);
        }

        try {
            res = executor.invokeAny(taskList);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            System.out.println(res);
        }

        executor.shutdown();
        System.out.println("...Result from any thread has been received");
    }
}
